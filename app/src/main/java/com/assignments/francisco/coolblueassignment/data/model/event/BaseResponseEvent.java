package com.assignments.francisco.coolblueassignment.data.model.event;

/**
 * Base event for http request.
 *
 * @param <T> response type.
 *
 * @author Francisco Visintini
 */
public abstract class BaseResponseEvent<T> {

    private T response;
    private int code;
    private Throwable throwable;

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

    /**
     * Validates if the call was successful or not by seeing if it has response and the response code is equals 200.
     *
     * @return true/false.
     */
    public boolean isSuccess() {
        return hasResponse() && code == 200;
    }

    /**
     * Get throwable of a failed call.
     *
     * @return throwable.
     */
    public Throwable getThrowable() {
        return throwable;
    }

    /**
     * Set throwable of a failed call.
     *
     * @param throwable
     */
    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
