package com.billyang.framework.shiro.web.filter.captcha;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.AccessControlFilter;

import com.billyang.common.constant.ShiroConstants;
import com.billyang.common.utils.StringUtils;
import com.billyang.common.utils.security.ShiroUtils;
import com.google.code.kaptcha.Constants;

public class CaptchaValidateFilter extends AccessControlFilter{

	/**
	 * 是否开启验证码
	 */
	private boolean captchaEbabled = true;
	/**
	 * 验证码类型
	 */
	private String captchaType = "math";
	@Override
	protected boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		//验证码禁用或不是表单提交 允许访问
		if(captchaEbabled==false || !"post".equals(httpServletRequest.getMethod().toLowerCase())){
			return false;
		}
		return validateResponse(httpServletRequest,httpServletRequest.getParameter(ShiroConstants.CURRENT_VALIDATECODE));
	}

	/**
	 * 验证码验证
	 * @param httpServletRequest
	 * @param validateCode
	 * @return
	 */
	private boolean validateResponse(HttpServletRequest httpServletRequest,String validateCode) {
		Object obj = ShiroUtils.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		String code = String.valueOf(obj!=null?obj:"");
		if(StringUtils.isEmpty(validateCode)||!validateCode.equalsIgnoreCase(code)){
			return false;
		}
		return true;
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
			throws Exception {
		request.setAttribute(ShiroConstants.CURRENT_CAPTCHA, ShiroConstants.CURRENT_ERROR);
		return false;
	}

	@Override
	public boolean onPreHandle(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		request.setAttribute(ShiroConstants.CURRENT_EBABLED, captchaEbabled);
		request.setAttribute(ShiroConstants.CURRENT_TYPE, captchaType);
		return super.onPreHandle(request, response, mappedValue);
	}

	public boolean isCaptchaEbabled() {
		return captchaEbabled;
	}

	public void setCaptchaEbabled(boolean captchaEbabled) {
		this.captchaEbabled = captchaEbabled;
	}

	public String getCaptchaType() {
		return captchaType;
	}

	public void setCaptchaType(String captchaType) {
		this.captchaType = captchaType;
	}

}
