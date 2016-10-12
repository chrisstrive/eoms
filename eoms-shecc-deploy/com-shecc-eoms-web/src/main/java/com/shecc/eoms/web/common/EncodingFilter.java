package com.shecc.eoms.web.common;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
*
* USER ray ray1192@163.com
* DATE 2014-2-11 下午08:35:21
* INFO com.shecc.eoms.web.common AuthFilter.java
* REMARK 字符集处理
*
*/
public class EncodingFilter extends OncePerRequestFilter {
	
	private String encoding;

	private boolean forceEncoding;

	/**
	 * Set the encoding to use for requests. This encoding will be passed into a
	 * ServletRequest.setCharacterEncoding call.
	 * <p>
	 * Whether this encoding will override existing request encodings depends on
	 * the "forceEncoding" flag.
	 * 
	 * @see #setForceEncoding
	 * @see javax.servlet.ServletRequest#setCharacterEncoding
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	/**
	 * Set whether the encoding of this filter should override existing request
	 * encodings. Default is "false", i.e. do not modify encoding if
	 * ServletRequest.getCharacterEncoding returns a non-null value.
	 * 
	 * @see #setEncoding
	 * @see javax.servlet.ServletRequest#getCharacterEncoding
	 */
	public void setForceEncoding(boolean forceEncoding) {
		this.forceEncoding = forceEncoding;
	}

	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (this.forceEncoding || request.getCharacterEncoding() == null) {
			request.setCharacterEncoding(this.encoding);
		}
		
		filterChain.doFilter(request, response);
	}
}
