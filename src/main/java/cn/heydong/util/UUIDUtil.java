package cn.heydong.util;

import java.io.File;
import java.util.UUID;

public class UUIDUtil {
    public static String makeUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    public static String makePathName(String uuid) {
        if(uuid.length()<32) return null;
        return uuid.substring(0, 2)
                    + "/"
                    + uuid.substring(10, 12)
                    + "/";
    }
}
