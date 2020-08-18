package com.project.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class EncodingUrl {
    public static String returnUrl(String role, String faculty, String specialty, String group, String date) throws UnsupportedEncodingException {
        StringBuilder redirect = new StringBuilder();
        redirect.append("redirect:/" + role + "/" +
                URLEncoder.encode(faculty, "UTF-8") + '/' +
                URLEncoder.encode(specialty, "UTF-8") + '/' +
                URLEncoder.encode(group, "UTF-8") + '/' +
                URLEncoder.encode(date, "UTF-8"));
        return redirect.toString().replace("+", "%20");
    }
}
