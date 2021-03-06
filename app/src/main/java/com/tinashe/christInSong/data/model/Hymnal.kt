/*
 * Copyright (c) 2019. Tinashe Mzondiwa.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tinashe.christInSong.data.model

import androidx.room.PrimaryKey

open class Hymnal(var name: String,

                  var language: String,

                  @PrimaryKey
                  var code: String) : Comparable<Hymnal> {

    constructor() : this("", "", "")

    var available: Boolean = false

    override fun equals(other: Any?): Boolean {
        return other is Hymnal && other.code == code
    }

    override fun hashCode(): Int {
        return code.hashCode()
    }

    override fun compareTo(other: Hymnal): Int {
        return when {
            code == "eng" -> -1
            available -> -1
            other.code == "eng" -> 1
            other.available -> 1
            else -> name.compareTo(other.name)
        }
    }
}