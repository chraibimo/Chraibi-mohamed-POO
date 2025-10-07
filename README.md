# TP IoC – Compte rendu (IDao / IMetier / Injection)

**Ressource vidéo** : https://www.youtube.com/watch?v=vOLqabN-n2k

## Objectifs
1. Interface `IDao#getData()` et son implémentation
2. Interface `IMetier#calcul()` et implémentation faiblement couplée
3. Injection des dépendances :
   - a) Instanciation **statique**
   - b) Instanciation **dynamique** (réflexion + `config.properties`)
   - c) **Spring** : version **XML** et version **annotations**

## Arborescence
```
ioc-demo/
  pom.xml
  README.md
  src/main/java/ma/enset/ioc/
    dao/IDao.java, DaoImpl.java
    ext/DaoImplV2.java
    metier/IMetier.java, MetierImpl.java
    pres/PresStatic.java, PresDynamic.java, PresSpringXml.java, PresSpringAnno.java
  src/main/resources/
    config.properties
    applicationContext.xml
    applicationContext-anno.xml
```

## Lancer rapidement (Java 17 requis)
```bash
# 1) Compilation
mvn -q -DskipTests package

# 2) Injection statique
mvn -q exec:java -Dexec.mainClass="ma.enset.ioc.pres.PresStatic"

# 3) Injection dynamique (modifie config.properties pour tester V2)
mvn -q exec:java -Dexec.mainClass="ma.enset.ioc.pres.PresDynamic"

# 4) Spring XML
mvn -q exec:java -Dexec.mainClass="ma.enset.ioc.pres.PresSpringXml"

# 5) Spring Annotations (component-scan)
mvn -q exec:java -Dexec.mainClass="ma.enset.ioc.pres.PresSpringAnno"
```

### Basculer entre DaoImpl et DaoImplV2 (dynamique)
Édite `src/main/resources/config.properties` :
```
dao.class=ma.enset.ioc.dao.DaoImpl      # ou ma.enset.ioc.ext.DaoImplV2
metier.class=ma.enset.ioc.metier.MetierImpl
```

## Notes
- **Couplage faible**: `MetierImpl` dépend de l’**interface** `IDao`, injectée par **setter** ou **constructeur**.
- **Spring** gère la création et l’injection des beans (XML ou annotations + `@Autowired`).

## Journal de commits (exemple)
- init: structure Maven + interfaces
- feat: DaoImpl + MetierImpl + PresStatic
- feat: PresDynamic + config.properties
- feat: Spring XML + PresSpringXml
- feat: Spring annotations + PresSpringAnno
- chore: README final
