# maven-study
Mavan 学习

## Maven profile
pom.xml 添加如下配置

```xml
<profiles>
    <profile>
        <!--不同环境profile的唯一id-->
        <id>dev</id>
        <properties>
            <!--profiles.envs 之自定义字段（名字随便起），自定义字段可以有多个-->
            <profile.env>dev</profile.env>
        </properties>
        <activation>
            <!-- 默认激活该profile节点-->
            <activeByDefault>true</activeByDefault>
        </activation>
    </profile>
    <profile>
        <id>pro</id>
        <properties>
            <profile.env>pro</profile.env>
        </properties>
    </profile>
</profiles>
<build>
    <resources>
        <resource>
            <directory>${basedir}/src/main/resources</directory>
            <excludes>
                <exclude>**</exclude>
            </excludes>
        </resource>
        <resource>
            <directory>${basedir}/src/main/resources/${profile.env}</directory>
        </resource>
    </resources>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-shade-plugin</artifactId>
            <version>3.1.1</version>
            <executions>
                <execution>
                    <phase>package</phase>
                    <goals>
                        <goal>shade</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```
编译的时候指定环境。

`mvn clean package -P dev|pro`

