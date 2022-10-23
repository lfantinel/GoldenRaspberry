package br.com.leandrofantinel.goldenraspberry.config.spring;

import br.com.leandrofantinel.goldenraspberry.util.json.MapperUtil;
import br.com.leandrofantinel.goldenraspberry.util.json.SafeObjectMapper;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Configuration
class JacksonProvider {

    @Bean
    SafeObjectMapper getSafeObjectMapper() {
        return new SafeObjectMapper();
    }

    @Bean
    @Scope(scopeName = SCOPE_PROTOTYPE)
    MapperUtil getMapperUtil (DependencyDescriptor ip, SafeObjectMapper mapper) {
        return new MapperUtil(ip, mapper);
    }


}
