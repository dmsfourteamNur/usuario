# DMSNUR - VUELO

## Alvaro Siles Estrada

#

Creamos el proyecto base

```bash
mvn archetype:generate -DgroupId=dmsnur -DartifactId=vuelo
```

Creamos los modulos

```bash
mvn archetype:generate -DgroupId=dmsnur -DartifactId=Domain
mvn archetype:generate -DgroupId=dmsnur -DartifactId=Application
mvn archetype:generate -DgroupId=dmsnur -DartifactId=Infraestructure
mvn archetype:generate -DgroupId=dmsnur -DartifactId=SharedKernel
mvn archetype:generate -DgroupId=dmsnur -DartifactId=WebApi
```

mvn clean  jacoco:prepare-agent test install jacoco:report
mvn clean  jacoco:prepare-agent