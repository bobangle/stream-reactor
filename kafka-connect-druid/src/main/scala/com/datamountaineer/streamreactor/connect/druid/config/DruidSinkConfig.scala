/**
  * Copyright 2016 Datamountaineer.
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  * http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  **/

package com.datamountaineer.streamreactor.connect.druid.config

import java.util

import org.apache.kafka.common.config.{AbstractConfig, ConfigDef}
import org.apache.kafka.common.config.ConfigDef.{Importance, Type}

object DruidSinkConfig {
  val DATASOURCE_NAME = "connect.druid.sink.datasource.name"
  val DATASOURCE_NAME_DOC =
    """
      |Specifies which datasource entry to pick from the configuration
    """.stripMargin

  val CONFIG_FILE = "connect.druid.sink.config.file"
  val CONFIG_FILE_DOC = "The path to the configuration file."


  val FIELDS = "connect.druid.sink.fields"
  val FIELDS_DOC =
    """
      |Specifies which of the payload fields to consider. If the config is not specified all fields are considered.
      |A field can be mapped to another by having: fieldName=aliasName.
      |If all
    """.stripMargin

  val TIMEOUT = "connnect.druid.sink.write.timeout"
  val TIMEOUT_DOC =
    """
      |Specifies the number of seconds to wait for the write to Druid to happen. If the setting is not specified it defaults to 600(10minutes)
    """.stripMargin

  val config: ConfigDef = new ConfigDef()
    .define(DATASOURCE_NAME, Type.STRING, Importance.HIGH, DATASOURCE_NAME_DOC, "Connection", 1, ConfigDef.Width.MEDIUM, DATASOURCE_NAME)
    .define(CONFIG_FILE, Type.STRING, Importance.HIGH, CONFIG_FILE_DOC, "Connection", 2, ConfigDef.Width.LONG, CONFIG_FILE)
    .define(FIELDS, Type.STRING, Importance.LOW, FIELDS_DOC, "Target", 1, ConfigDef.Width.MEDIUM, FIELDS)
    .define(TIMEOUT, Type.INT, Importance.LOW, TIMEOUT_DOC, "Connection", 3, ConfigDef.Width.SHORT, TIMEOUT)
}

/**
  * <h1>HbaseSinkConfig</h1>
  *
  * Holds config, extends AbstractConfig.
  **/
class DruidSinkConfig(props: util.Map[String, String])
  extends AbstractConfig(DruidSinkConfig.config, props)
