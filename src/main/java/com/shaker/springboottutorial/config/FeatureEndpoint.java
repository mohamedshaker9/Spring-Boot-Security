package com.shaker.springboottutorial.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features")
public class FeatureEndpoint {
    private Map<String, Feature> featuresMap =
            new ConcurrentHashMap<>();

    public FeatureEndpoint(){
        featuresMap.put("getDepartments" , new Feature(true));
        featuresMap.put("deleteDepartments" , new Feature(true));
        featuresMap.put("updateDepartments" , new Feature(true));


    }

    @ReadOperation
    public Feature feature(@Selector String feature){
        return featuresMap.get(feature);
    }

    @ReadOperation
    public Map<String, Feature> features(){
        return featuresMap;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature{
        private boolean isEnalbled;
    }
}
