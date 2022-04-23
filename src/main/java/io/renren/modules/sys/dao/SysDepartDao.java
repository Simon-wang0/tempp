package io.renren.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.sys.entity.SysDepartEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysDepartDao extends BaseMapper<SysDepartEntity> {

  void deletRoleByDepartId(@Param("id") Long id,@Param("roleId")long roleId);

  Integer queryIsExsit(@Param("departId") long departId, @Param("roleId") long roleId);

  void saveDepartAndRole(@Param("departId") long departId, @Param("roleId") long roleId);
  void updateDepartAndRole(@Param("departId") long departId, @Param("roleId") long roleId);

  Long isSameDepart(@Param("name") String name);

}
