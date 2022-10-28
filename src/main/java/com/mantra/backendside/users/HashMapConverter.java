package com.mantra.backendside.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.persistence.AttributeConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mantra.backendside.users.CustomInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.Map;

public class HashMapConverter implements AttributeConverter<Map<String, Object>, String> {

    private static final Logger logger = LoggerFactory.getLogger(CustomInterceptor.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

@Override
public String convertToDatabaseColumn(Map<String, Object> wallpaperInfo) {

        String wallpaperInfoJSON = null;
        try {
        wallpaperInfoJSON = objectMapper.writeValueAsString(wallpaperInfo);
        } catch (final JsonProcessingException e) {
        logger.error("JSON writing error", e);
        }

        return wallpaperInfoJSON;
        }

@Override
public Map<String, Object> convertToEntityAttribute(String wallpaperMapJSON) {

        Map<String, Object> wallpaperInfo= null;
        try {
        wallpaperInfo = objectMapper.readValue(wallpaperMapJSON, Map.class);
        } catch (final IOException e) {
        logger.error("JSON reading error", e);
        }

        return wallpaperInfo;
        }

        }
