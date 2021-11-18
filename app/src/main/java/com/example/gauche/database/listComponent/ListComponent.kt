package com.example.gauche.database.listComponent

import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import androidx.room.Entity

/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ /**
 * A basic class representing an entity that is a row in a one-column database table.
 *
 * @ Entity - You must annotate the class as an entity and supply a table name if not class name.
 * @ PrimaryKey - You must identify the primary key.
 * @ ColumnInfo - You must supply the column name if it is different from the variable name.
 *
 * See the documentation for the full rich set of annotations.
 * https://developer.android.com/topic/libraries/architecture/room.html
 */
@Entity(
    tableName = "ListComponent_table"
)
class ListComponent(
    @field:ColumnInfo(name = "typComponent",index = true) @field:PrimaryKey(autoGenerate = true) var typeComponent: Int?,
    @field:ColumnInfo(name = "nameComponent",index = true) var nameComponent: String,
    @field:ColumnInfo(name = "unite",index = true) var unite: String
)
{
    constructor(nameComponent: String,unite: String):this(null,
        nameComponent,unite)
}