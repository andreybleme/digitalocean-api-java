/**
 * The MIT License
 *
 * Copyright (c) 2013-2017 Jeevanandam M. (myjeeva.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.myjeeva.digitalocean.common;

import com.google.gson.annotations.SerializedName;

/**
 * Enumeration of DigitalOcean load balancer status.
 *
 * @author Thomas Lehoux (https://github.com/tlehoux)
 *
 * @since v2.11
 */
public enum LoadBalancerStatus {

    @SerializedName("new")
    NEW("new"),

    @SerializedName("active")
    ACTIVE("active"),

    @SerializedName("errored")
    ERRORED("errored");

    private String value;

    private LoadBalancerStatus(String value) {
        this.value = value;
    }

    public static LoadBalancerStatus fromValue(String value) {
        if (null == value || "".equals(value)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }

        for (LoadBalancerStatus ds : LoadBalancerStatus.values()) {
            if (value.equalsIgnoreCase(ds.value)) {
                return ds;
            }
        }

        throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
    }

    @Override
    public String toString() {
        return this.value;
    }
}
