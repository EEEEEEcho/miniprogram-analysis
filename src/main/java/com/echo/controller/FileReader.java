package com.echo.controller;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReader {
    public static void readFile(String path){
        try {
//            List<String> strings = Files.readAllLines(Path.of(path), Charset.defaultCharset());
//            strings.forEach(System.out::println);
            byte[] fileBytes = Files.readAllBytes(Paths.get(path));
            String s = new String(fileBytes);
//            String s = "                onLoad: function(n) {\n" +
//                    "                    this.distributor = r.default.getDistributor(), this.distributor < 0 && (this.distributor = r.default.base_distributor, \n" +
//                    "                    r.default.setDistributor(r.default.base_distributor));\n" +
//                    "                    var t = n.code;\n" +
//                    "                    t ? (this.hasCode = !0, this.h5LoginByCode(t)) : this.loadData();\n" +
//                    "                },";
//            String pattern = "((\\s+)\\w+:(\\s?)function(.*},))";
            //String pattern = "(([a-zA-Z]\\w+):(\\s+?)function(.*?)})";
            Pattern regex = Pattern.compile("[a-zA-Z]\\w+:\\s+?function\\s*?" +
                            "\\(.*?\\)\\s*?\\{[^{}]*?(\\{.*?\\})*[^{}]*?\\}+?",
                    Pattern.DOTALL | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE | Pattern.MULTILINE);
            //Pattern compile = Pattern.compile(pattern,Pattern.MULTILINE);
            //Matcher matcher = compile.matcher(s);
            Matcher matcher = regex.matcher(s);
            while (matcher.find()){
                String group = matcher.group(0);
                System.out.println(group);
                System.out.println("--------------------------");
            }
            //System.out.println(s);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileReader.readFile("F:\\miniprogram-analysis\\file2analysis\\index2.js");
    }
}
