package com.chemistry.utils;

public class ModelUtil {


    //Implemented from https://fabricmc.net/wiki/tutorial:dynamic_model_generation
    public static String createItemModelJson(String id, String type) {
        if ("generated".equals(type) || "handheld".equals(type)) {
            return "{\n" +
                    "  \"parent\": \"item/" + type + "\",\n" +
                    "  \"textures\": {\n" +
                    "    \"layer0\": \"chemistry:item/" + id + "\"\n" +
                    "  }\n" +
                    "}";
        } else if ("block".equals(type)) {
            return "{\n" + "  \"parent\": \"chemistry:block/" + id + "\"\n}";
        }
        else {
            return "";
        }
    }

    public static String createElementModelJson(String id) {
        return "{\n" +
                "  \"parent\": \"item/generated\",\n" +
                "  \"textures\": {\n" +
                "    \"layer0\": \"chemistry:" + id + "\"\n" +
                "  }\n" +
                "}";
    }
}
