package net.messi.early.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.messi.early.VO.ChatVO;
import net.messi.early.dto.NearShop;

import java.util.List;

public class JsonToObject {

    public static List<NearShop> toObj(String content) {
        Gson gson = new Gson();
        List<NearShop> nearShops = gson.fromJson(content, new TypeToken<List<NearShop>>() {
        }.getType());
        return nearShops;
    }

    public static ChatVO toChatVo(String content) {
        Gson gson = new Gson();
        ChatVO info = gson.fromJson(content, new TypeToken<ChatVO>() {
        }.getType());
        return info;
    }

}
