package com.intelliswift.urlshortner.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import com.intelliswift.urlshortner.utility.GoogleURLShortener;

@WebServlet(asyncSupported = true, urlPatterns = { "/GenerateShortUrl" })
public class GenerateShortUrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GenerateShortUrl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String longUrl = request.getParameter("longurl");
		String customerId = request.getParameter("customerId");
		
		// encode data on your side using BASE64
		byte[]   bytesEncoded = Base64.encodeBase64(customerId.getBytes());
		String encodedCustomerId = new String(bytesEncoded );
		System.out.println("ecncoded value is " + new String(encodedCustomerId ));

		/*// Decode data on other side, by processing encoded data
		byte[] valueDecoded= Base64.decodeBase64(bytesEncoded );
		System.out.println("Decoded value is " + new String(valueDecoded));*/
		
		PrintWriter out = response.getWriter();
		out.print(GoogleURLShortener.getShortUrl(longUrl+"?cid="+encodedCustomerId));
	}

}
