/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dolphinscheduler.common.enums.dq;

import java.util.HashMap;
import java.util.Map;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * failure policy when dqs task node failed.
 */
public enum DqFailureStrategy {
    /**
     * 0-ending process when dqs tasks failed.
     * 1-continue running when dqs tasks failed.
     * 2-ending process and alter when dqs tasks failed.
     * 3-continue running and alter when dqs tasks failed.
     **/
    END(0, "end"),
    CONTINUE(1, "continue"),
    END_ALTER(2, "end_alter"),
    CONTINUE_ALTER(3, "continue_alter");

    DqFailureStrategy(int code, String description) {
        this.code = code;
        this.description = description;
    }

    @EnumValue
    private final int code;
    private final String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    private static final Map<Integer, DqFailureStrategy> VALUES_MAP = new HashMap<>();

    static {
        for (DqFailureStrategy type : DqFailureStrategy.values()) {
            VALUES_MAP.put(type.code,type);
        }
    }

    public static DqFailureStrategy of(Integer status) {
        if (VALUES_MAP.containsKey(status)) {
            return VALUES_MAP.get(status);
        }
        throw new IllegalArgumentException("invalid code : " + status);
    }
}