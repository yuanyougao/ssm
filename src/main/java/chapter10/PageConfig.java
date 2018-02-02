package chapter10;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan
@ImportResource({"chapter10/spring-dataSource.xml"})
public class PageConfig {

}
