package coeo.ibuki.controller.admin;

import coeo.ibuki.entity.Admin;
import coeo.ibuki.entity.NewsCategory;
import coeo.ibuki.service.AdminService;
import coeo.ibuki.service.CategoryService;
import coeo.ibuki.util.PageQueryUtil;
import coeo.ibuki.util.Result;
import coeo.ibuki.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@SuppressWarnings("rawtypes")
@Controller
@RequestMapping("/admin")
public class CategoryController {

    @Resource
    private CategoryService categoryService;
    @Resource
    private AdminService adminService;

    @GetMapping("/categories")
    public String categoryPage(HttpServletRequest request) {
    	
		Long loginUserId = (long) request.getSession().getAttribute("loginUserId");
        Admin adminUser = adminService.getUserDetailById(loginUserId);
        if (adminUser == null) {
            return "admin/login";
        }
		request.setAttribute("loginUserName", adminUser.getLoginName());
		
        request.setAttribute("path", "categories");
        return "admin/category";
    }

    /**
     * 分类列表
     */
	@RequestMapping(value = "/categories/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(categoryService.getCategoryPage(pageUtil));
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/categories/info/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Result info(@PathVariable("id") Long id) {
        NewsCategory newsCategory = categoryService.queryById(id);
        return ResultGenerator.genSuccessResult(newsCategory);
    }


    /**
     * 分类添加
     */
    @RequestMapping(value = "/categories/save", method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestParam("categoryName") String categoryName) {
        if (StringUtils.isEmpty(categoryName)) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (categoryService.saveCategory(categoryName)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("分类名称重复");
        }
    }


    /**
     * 分类修改
     */
    @RequestMapping(value = "/categories/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestParam("categoryId") Long categoryId,
                         @RequestParam("categoryName") String categoryName) {
        if (StringUtils.isEmpty(categoryName)) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (categoryService.updateCategory(categoryId, categoryName)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("分类名称重复");
        }
    }


    /**
     * 分类删除
     */
    @RequestMapping(value = "/categories/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (categoryService.deleteBatchByIds(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

}

