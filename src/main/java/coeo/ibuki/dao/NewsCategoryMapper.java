package coeo.ibuki.dao;

import coeo.ibuki.entity.NewsCategory;
import coeo.ibuki.util.PageQueryUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NewsCategoryMapper {

    List<NewsCategory> findCategoryList(PageQueryUtil pageUtil);

    int getTotalCategories(PageQueryUtil pageUtil);

    int deleteByPrimaryKey(Long categoryId);

    int insert(NewsCategory record);

    int insertSelective(NewsCategory record);

    NewsCategory selectByPrimaryKey(Long categoryId);

    NewsCategory selectByCategoryName(String categoryName);

    int updateByPrimaryKeySelective(NewsCategory record);

    int updateByPrimaryKey(NewsCategory record);

    int deleteBatch(Integer[] ids);
}
