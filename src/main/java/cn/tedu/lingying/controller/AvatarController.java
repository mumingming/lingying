package cn.tedu.lingying.controller;

import cn.tedu.lingying.controller.ex.*;
import cn.tedu.lingying.entity.Avatar;
import cn.tedu.lingying.service.AvatarService;
import cn.tedu.lingying.util.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 处理用户数据相关请求的控制器类
 */
@RestController
public class AvatarController extends BaseController {


    @Resource
    private AvatarService service;
	

/*	@RequestMapping("/upload")
	public Object insert(MultipartFile file,HttpServletRequest request) throws IOException{
		
		String imgpath = null;
		Avatar fileP0 = new Avatar();
		
		try {
			CommonsMultipartFile endFile=(CommonsMultipartFile)file;
			
			imgpath = ImageUtils.upload(request, endFile);
			System.out.println(imgpath);
			if(imgpath !=null) {
				fileP0.setAvatar(imgpath);
			}
			
			int save = service.insert(fileP0);
			
			Map<String,Object> map = new HashMap<>();
			map.put( "state", 2000);
			map.put("msg", "");
			map.put("data", fileP0);
			map.put("src", imgpath);
			return map;
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
		
	}*/


    //文件夹位置
    public static final String AVATAR_DIR = "upload/";
    //文件大小
    public static final int AVATAR_MAX_SIZE = 1 * 1024 * 1024;
    //文件类型格式
    public static final List<String> AVATAR_CONTENT_TYPES = new ArrayList<>();

    static {
        AVATAR_CONTENT_TYPES.add("image/jpeg");
        AVATAR_CONTENT_TYPES.add("image/png");
    }


    @RequestMapping(value = ("/upload"), method = RequestMethod.POST)
    public JsonResult<String> changeAvatar(
            HttpServletRequest request,
            @RequestParam("file") MultipartFile file, String cpname) {


        // 检查文件是否为空
        if (file.isEmpty()) {
            throw new FileEmptyException(
                    "上传失败！请选择有效的文件！");
        }

        // 检查文件大小
        if (file.getSize() > AVATAR_MAX_SIZE) {
            throw new FileSizeException(
                    "上传失败！不允许使用超过" + (AVATAR_MAX_SIZE / 1024) + "KB的文件！");
        }

        // 检查文件类型
        if (!AVATAR_CONTENT_TYPES.contains(file.getContentType())) {
            throw new FileTypeException(
                    "上传失败！仅允许使用以下类型的图片文件：" + AVATAR_CONTENT_TYPES);
        }

        // 确定文件夹
        String dirPath = request.getServletContext().getRealPath("upload");
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 确定文件名
        String originalFilename = file.getOriginalFilename();
        String suffix = "";
        int beginIndex = originalFilename.lastIndexOf(".");
        if (beginIndex != -1) {
            suffix = originalFilename.substring(beginIndex);
        }
        String filename = UUID.randomUUID().toString() + suffix;

        // 执行保存
        File dest = new File(dir, filename);
        System.err.println("将文件保存到：" + dest);
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            throw new FileUploadStateException(
                    "上传失败！请检查原文件是否存在并可以被访问！");
        } catch (IOException e) {
            throw new FileUploadIOException(
                    "上传失败！读出数据时出现未知错误！");
        }

        // 更新数据表
        String address = '/' + AVATAR_DIR + filename;
        //HttpSession session = request.getSession();
        //Integer uid = getUidFromSession(session);
        System.err.println(address);

        service.insert(address, cpname);

        // 返回
        JsonResult<String> jr = new JsonResult<>();
        jr.setState(SUCCESS);
        jr.setData(address);
        return jr;
    }


    /**
     * 查询图片并展示
     *
     * @param cpname
     * @return
     */
    @RequestMapping(value = ("/tupian"), method = RequestMethod.GET)
    public JsonResult<List<Avatar>> getBycpname(String cpname) {

        // 调用业务层对象获取数据
        List<Avatar> data = service.findbycpname(cpname);

        // 返回
        return new JsonResult<>(SUCCESS, data);
    }


    /**
     * 根据图片地址编辑删除图片
     *
     * @param address
     * @return
     */
    @RequestMapping(value = ("/deletebyaddress"), method = RequestMethod.GET)
    public JsonResult<Object> deletebyaddress(String address) {

        // 调用业务层对象获取数据
        service.deletebyaddress(address);

        // 返回
        return new JsonResult<>(SUCCESS);
    }


}