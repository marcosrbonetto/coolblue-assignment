package com.assignments.francisco.coolblueassignment.data.event;

/**
 * Base event for http request.
 * @param <T> response type.
 */
public abstract class BaseResponseEvent<T> {

    private T response;
    private int code;

    /**
     * Get response of HTTP request.
     *
     * @return response data.
     */
    public T getResponse() {
        return response;
    }

    /**
     * Set response of HTTP request.
     *
     * @param response data.
     */
    public void setResponse(T response) {
        this.response = response;
    }

    /**
     * Get HTTP status code.
     *
     * @return HTTP status code.
     */
    public int getCode() {
        return code;
    }

    /**
     * Set HTTP status code.
     *
     * @param code HTTP status code.
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Returns true if request contains response.
     *
     * @return true/false.
     */
    public boolean hasResponse() {
        return response != null;
    }
}
