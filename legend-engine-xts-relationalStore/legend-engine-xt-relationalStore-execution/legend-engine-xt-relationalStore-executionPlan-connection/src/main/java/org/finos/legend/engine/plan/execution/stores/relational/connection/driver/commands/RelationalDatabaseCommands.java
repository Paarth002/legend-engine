// Copyright 2021 Goldman Sachs
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package org.finos.legend.engine.plan.execution.stores.relational.connection.driver.commands;

import java.util.List;

public abstract class RelationalDatabaseCommands
{
    public String processTempTableName(String tempTableName)
    {
        return tempTableName;
    }

    public abstract String dropTempTable(String tableName);

    public abstract List<String> createAndLoadTempTable(String tableName, List<Column> columns, String optionalCSVFileLocation);

    public abstract <T> T accept(RelationalDatabaseCommandsVisitor<T> visitor);

    public String load(String tableName, String location)
    {
        throw new RuntimeException("Load not implemented for " + this.getClass().getSimpleName());
    }

    public String load(String tableName, String location, List<Column> columns)
    {
        throw new RuntimeException("Load not implemented for " + this.getClass().getSimpleName());
    }

    public String dropTable(String tableName)
    {
        throw new RuntimeException("Drop table not implemented for " + this.getClass().getSimpleName());
    }

    public abstract IngestionMethod getDefaultIngestionMethod();

    public boolean supportsHeaderOnCsvFile()
    {
        return true;
    }

    public String createTempTable(String tableName, List<Column> columns)
    {
        throw new RuntimeException("Create Temp not implemented for " + this.getClass().getSimpleName());
    }

//    public void buildTempTableFromResult(RelationalExecutionConfiguration config, Connection connection, StreamingResult result, String tableName)
//    {
//        buildTempTableFromResult(config, connection, result, tableName, this.getDefaultIngestionMethod());
//    }
//
//    protected abstract void buildTempTableFromResult(RelationalExecutionConfiguration config, Connection connection, StreamingResult result, String tableName, IngestionMethod ingestionMethod);
}
