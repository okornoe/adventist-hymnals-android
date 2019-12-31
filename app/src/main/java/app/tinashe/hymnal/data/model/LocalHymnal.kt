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

package app.tinashe.hymnal.data.model

import androidx.room.Entity
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize
import java.util.Calendar
import java.util.Date

@Parcelize
@Entity(tableName = "hymnals")
class LocalHymnal : Hymnal() {

    @IgnoredOnParcel
    var lastAccessed: Date? = null

    companion object {

        val default: LocalHymnal = LocalHymnal().apply {
            code = "eng"
            name = "Christ In Song"
            language = "English"
            available = true
            lastAccessed = Date()
        }

        fun fromHymnal(hymnal: Hymnal): LocalHymnal {

            return LocalHymnal().apply {
                name = hymnal.name
                language = hymnal.language
                code = hymnal.code
                lastAccessed = Calendar.getInstance().time
                available = true
            }
        }
    }
}