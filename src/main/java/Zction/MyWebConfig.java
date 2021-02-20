package Zction;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    /*拦截 ，拦截所有的 ，放行登陆，或者入口 ， 以及静态资源static(暂时无静态资源)
    *
    * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Firlter())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/login","/my2");
    }


    /*配置数据源启用drudi数据源,绑定配置文件 ，启动监控
    * */
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource()  ;
        druidDataSource.setFilters("stat");
        return druidDataSource;
    }


    /*配置阿里云drudi数据源监控，加入容器中，添加拦截路径（可以drudi/*,也可以使用其他的urlMapping）
    * */
    @Bean
    public ServletRegistrationBean statViewServlet()  {

        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(statViewServlet,"/druid/*");
        return  registrationBean;
    }

}
