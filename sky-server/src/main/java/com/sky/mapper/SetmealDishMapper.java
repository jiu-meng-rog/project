package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查询对应的套餐
     * @param dishIds
     * @return
     */
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    /**
     * 新增套餐所含的菜品
     * @param setmealDishes
     */
    void insert(List<SetmealDish> setmealDishes);

    /**
     * 根据SetmealId删除相关菜品和套餐的关联
     * @param setmealid
     */
    @Delete("delete from setmeal_dish where setmeal_id = #{setmealid}")
    void deleteBySetmealId(Long setmealid);

    /**
     * 根据套餐id查询菜品
     * @return
     */
    @Select("select * from setmeal_dish where setmeal_id = #{setmealid}")
    List<SetmealDish> getBySetmealId();
}
