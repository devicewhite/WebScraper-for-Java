# WebScraper-for-Java

### English Tutorial: Web Scraper for Android

#### Introduction:
This Android WebScraper class allows you to extract content from a web page using Java. It includes basic error handling and uses HttpURLConnection for web interactions.

#### How to Use:
1. **Initialize WebScraper:**
   ```java
   WebScraper webScraper = new WebScraper("https://example.com");
   ```

2. **Get Web Page Content:**
   ```java
   String pageContent = webScraper.getContent();
   ```

3. **Find Patterns in Content:**
   ```java
   String[] patterns = webScraper.findWithPattern("<your-regex-pattern>");
   ```

#### Example Usage:
```java
WebScraper webScraper = new WebScraper("https://example.com");
String pageContent = webScraper.getContent();

if (!pageContent.equals("(void)")) {
    Log.e("WebScraper", "Web Page Content:\n" + pageContent);

    String[] patterns = webScraper.findWithPattern("<your-regex-pattern>");
    Log.e("Matched Patterns:");
    for (String pattern : patterns) {
        Log.e(pattern);
    }
} else {
    Log.e("WebScraper", "Failed to fetch web page content.");
}
```

#### Note:
- Ensure you have the internet permission in your AndroidManifest.xml file.

### Tutorial em Português: Web Scraper para Android

#### Introdução:
Esta classe Android WebScraper permite extrair conteúdo de uma página da web usando Java. Inclui tratamento básico de erros e usa HttpURLConnection para interações web.

#### Como Usar:
1. **Inicializar o WebScraper:**
   ```java
   WebScraper webScraper = new WebScraper("https://example.com");
   ```

2. **Obter Conteúdo da Página Web:**
   ```java
   String pageContent = webScraper.getContent();
   ```

3. **Encontrar Padrões no Conteúdo:**
   ```java
   String[] patterns = webScraper.findWithPattern("<seu-padrao-de-regex>");
   ```

#### Exemplo de Uso:
```java
WebScraper webScraper = new WebScraper("https://example.com");
String pageContent = webScraper.getContent();

if (!pageContent.equals("(void)")) {
    Log.e("WebScraper", "Conteúdo da Página Web:\n" + pageContent);

    String[] patterns = webScraper.findWithPattern("<seu-padrao-de-regex>");
    Log.e("Padrões Encontrados:");
    for (String pattern : patterns) {
        Log.e(pattern);
    }
} else {
    Log.e("WebScraper", "Falha ao obter o conteúdo da página web.");
}
```

#### Observação:
- Certifique-se de ter a permissão de internet no arquivo AndroidManifest.xml.