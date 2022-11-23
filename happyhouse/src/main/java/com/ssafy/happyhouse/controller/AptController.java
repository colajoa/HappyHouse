package com.ssafy.happyhouse.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.CodeDto;
import com.ssafy.happyhouse.exception.CustomException;
import com.ssafy.happyhouse.exception.ErrorCode;
import com.ssafy.happyhouse.service.AptServiceImpl;

@RestController
@RequestMapping("/apt")
public class AptController {

    @Value("${apt.api.key}")
    private String apiKey;

    @Autowired
    private AptServiceImpl aptService;

    // 시도 목록 불러오기
    @GetMapping("/sido")
    public ResponseEntity<?> getSido() throws Exception{
        List<CodeDto> list = aptService.getSido(null);

        return ResponseEntity.ok(list);
    }

    /**
     * 구군 정보 불러오기
     * 
     * @param code
     * @return
     */
    @GetMapping("/gugun/{code}")
    public ResponseEntity<?> getGugun(@PathVariable("code") String code) throws Exception{
        CodeDto data = CodeDto.builder().code(code).build();
        List<CodeDto> list = aptService.getGugun(data);
        return ResponseEntity.ok(list);
    }

    /**
     * 동 코드 불러오기
     * 
     * @param code
     * @return
     */
    @GetMapping("/dong/{code}")
    public ResponseEntity<?> getDong(@PathVariable("code") String code) throws Exception{
        CodeDto data = CodeDto.builder().code(code).build();
        List<CodeDto> list = aptService.getDong(data);

        return ResponseEntity.ok(list);
    }

    /**
     * 아파트 매매가 정보 불러오기
     * 
     * @param code
     * @param dealYear
     * @param dealMonth
     * @return 
     */
    @GetMapping("/aptlist/{code}/{date}")
    public ResponseEntity<?> getAptList(@PathVariable("code") String code,
        @PathVariable("date") String date) throws Exception{

            System.out.println(apiKey);
        
        StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + apiKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("LAWD_CD","UTF-8") + "=" + URLEncoder.encode(code, "UTF-8")); /*지역코드*/
        urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD","UTF-8") + "=" + URLEncoder.encode(date, "UTF-8")); /*계약월*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        // System.out.println(sb.toString());

        if(!sb.toString().contains("200"))  throw new CustomException(ErrorCode.SERVER_ERROR);

        JSONObject json = XML.toJSONObject(sb.toString());
        System.out.println(json);
        // return ResponseEntity.ok(list);
        return ResponseEntity.ok(json.toMap());
    }
}