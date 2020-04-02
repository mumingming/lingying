package cn.tedu.lingying.mapper;

import cn.tedu.lingying.entity.Avatar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AvatarMapper {

    /**
     * 添加图片
     *
     * @param address
     * @return
     */

    Integer insert(@Param("address") String address
            , @Param("cpname") String cpname);


    /**
     * 根据公司名字查询图片进行详情页和编辑页的添加
     *
     * @param cpname
     * @return
     */
    List<Avatar> find(String cpname);


    /**
     * 根据公司名字修改图片
     *
     * @param address
     * @param cpname
     * @return
     */
    Integer updateAvatar(
            @Param("address") String address,
            @Param("cpname") String cpname);


    /**
     * 通过图片地址删除对应的图片
     *
     * @param address
     * @return
     */
    Integer delbyaddress(String address);


}
