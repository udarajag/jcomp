package com.udara.bkl.main;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.JsonDiff;

public class CompMain {

	public static void main(String[] args) {
		CompMain main = new CompMain();
		try {
			JsonNode patch = JsonDiff.asJson(main.getJson("json/1.json"), main.getJson("json/2.json"));
			System.out.println(patch.toString());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public JsonNode getJson(String filePath) throws JsonProcessingException, IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root = mapper.readTree(new File(classLoader.getResource(filePath).getFile()));
		return root;

	}

}
