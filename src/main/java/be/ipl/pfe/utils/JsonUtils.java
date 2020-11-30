package be.ipl.pfe.utils;

import java.util.Collections;
import java.util.Map;

public class JsonUtils {

	public static String stringToJson(String key, String value) {
		return "{\"" + key + "\":\"" + value + "\"}";
	}

	public static Map<String, String> errorToJson(String error) {
		return Collections.singletonMap("error", error);
	}

}
