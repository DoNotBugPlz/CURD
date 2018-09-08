package cn.qingtian.crud.test;

import cn.qingtian.crud.bean.Employee;
import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

/**
 * @Description:
 * @Author:Dn
 * @Date:Create in 下午11:22 2018/9/5
 * @Modifid By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "file:../../../web/WEB-INF/dispatcherServlet-servlet.xml"})
public class MvcTest {
    @Autowired
    WebApplicationContext context;
    MockMvc mockMvc;


    @Before
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPage() throws Exception {
        //模拟请求拿到返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/emps")
                .param("pn", "1"))
                .andReturn();

        //请求成功后，请求域中会有pageInfo，我们可以取出pageInfo进行验证

        MockHttpServletRequest request = result.getRequest();
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码:" + pageInfo.getPageNum());
        System.out.println("当前页码:" + pageInfo.getTotal());
        System.out.println("当前页码:" + pageInfo.getPages());
        int[] nums = pageInfo.getNavigatepageNums();
        for (int i : nums
                ) {
            System.out.println("  " + i);
        }
       ArrayList<Employee> employeeArrayList  =(ArrayList<Employee>) pageInfo.getList();
        employeeArrayList.forEach(i->System.out.print(i));


    }
}
