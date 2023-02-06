package config;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    //configuration class
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ DbConfig.class };
    }

    //ViewResolver
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ WebConfig.class };
    }
    //url for app
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter UTF8Filter = new CharacterEncodingFilter();
        UTF8Filter.setEncoding("UTF-8");
        UTF8Filter.setForceEncoding(true);

        HiddenHttpMethodFilter hiddenFilter = new HiddenHttpMethodFilter();
        return new Filter[] { UTF8Filter, hiddenFilter };
    }

}