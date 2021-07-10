# LanguageSystem

## Benutzung

Erstellen des LanguageSystem

```java
final LanguageSystem languageSystem=new LanguageSystem();
```

Nachricht aus Sprachdatei auslesen

```java
final LanguageMessages languageMessages=languageSystem.getLanguageMessage(Language.German);
final String message=languageMessages.getString("testMessage");
```

## Neue Sprache

Zum hinzufügen einer neuen Sprache muss diese einfach nur in den Language Enum erstellt werden und dazu eine JSON Datei
im ``languages/`` Resource Ordner

---

<img src="https://raw.githubusercontent.com/Spark61/LanguageSystem/master/github-metrics.svg">
