# Obilet.com Test Otomasyon Projesi

Bu proje, Obilet.com mülakat sürecinde verilen casedeki otomatik testleri gerçekleştirmek amacıyla geliştirilmiş bir Gauge test otomasyon projesidir. Proje, Selenium WebDriver ve Gauge framework’ü kullanarak tarayıcı otomasyonu sağlar ve test senaryolarını Markdown formatında tanımlar.

## Gereksinimler

- **Java 17**: Proje için gerekli olan Java sürümü.
- **Maven**: Proje bağımlılıklarını yönetmek ve derleme işlemlerini gerçekleştirmek için kullanılır.
- **Gauge**: Test senaryolarını yazmak ve koşturmak için gerekli olan test otomasyon aracıdır.
- **Selenium WebDriver**: Tarayıcı otomasyonu için gereklidir.

## Java Kurulumu

Projenin çalışabilmesi için Java 17 sürümünün sisteminizde yüklü olması gerekmektedir. Java sürümünü kontrol etmek için:

```sh
java -version
```

Eğer Java 17 yüklü değilse, resmi Java indirme sayfasından Java 17 JDK’yı indirebilirsiniz.

## Maven Kurulumu

Maven'ın yüklü olup olmadığını kontrol etmek için:

```sh
mvn -version
```

Eğer Maven yüklü değilse, Apache Maven resmi sitesinden indirin ve sisteminize kurun.

## Gauge Kurulumu

Gauge, test senaryolarını yazmak ve koşturmak için kullanılan bir test otomasyon aracıdır.

### MacOS için Gauge Kurulumu:

```sh
brew install gauge
```

### Windows için Gauge Kurulumu:

Gauge indirme sayfasından Windows kurulum paketini indirip kurabilirsiniz.

### Linux için Gauge Kurulumu:

#### Debian tabanlı dağıtımlar için

```sh
sudo apt-key adv --keyserver hkp://pool.sks-keyservers.net --recv-keys 023EDB0B
sudo apt-get update
sudo apt-get install -y gauge
```

### Gauge Eklentilerinin Yüklenmesi:

Projenin doğru bir şekilde çalışması için Java eklentisinin yüklü olması gerekmektedir:

```sh
gauge install java
```

## IDE Entegrasyonu

Eğer IntelliJ IDEA kullanıyorsanız, Gauge eklentisini aşağıdaki adımlarla yükleyebilirsiniz:

1. **Settings** menüsünden **Plugins** sekmesine gidin.
2. **Marketplace** bölümünde “Gauge” araması yapın.
3. “Gauge” eklentisini seçip **Install** butonuna tıklayın.
4. IDE’yi yeniden başlatın.

## Bağımlılıkların Yüklenmesi ve Projenin Derlenmesi

Aşağıdaki komut, `pom.xml` dosyasında tanımlı olan tüm bağımlılıkları yükler ve projeyi derler:

```sh
mvn clean install
```

Bu komut, proje dizinini temizler, gerekli bağımlılıkları indirir ve projeyi derler.

## Kurulum Adımları

1. **Projeyi Klonlayın**: GitHub üzerindeki depo adresine gidin ve `git clone` komutunu kullanarak projeyi yerel makinenize indirin.

```sh
git clone https://github.com/karyaboyraz/ObiletTestAutomationProject.git
```

2. **Proje Dizini**: Klonlama tamamlandıktan sonra proje dizinine geçiş yapın:

```sh
cd ObiletTestAutomationProject
```

3. **Bağımlılıkları Yükleyin ve Derleyin**: Proje bağımlılıklarını yüklemek ve projeyi derlemek için Maven kullanın:

```sh
mvn clean install
```

4. **Gauge Eklentilerini Yükleyin**: Gauge test senaryolarını çalıştırmak için gerekli eklentileri yükleyin:

```sh
gauge install java
```

5. **Testleri Çalıştırın**: Test senaryolarını çalıştırmak için aşağıdaki komutu kullanabilirsiniz:

```sh
mvn gauge:execute
```

veya doğrudan Gauge komutunu kullanabilirsiniz:

```sh
gauge run specs
```

## Proje Yapısı

Proje, aşağıdaki klasör yapısına sahiptir:

```
ObiletTestAutomationProject/
├── pom.xml
├── manifest.json
├── src/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── obilettest/
│       │               ├── com.example.obilettest.Methods/
│       │               │   ├── ConfigReader.java
│       │               │   └── UserDataGenerator.java
│       │               ├── com.example.obilettest.driver/
│       │               │   ├── DriverFactory.java
│       │               │   └── BaseDriver.java
│       │               ├── steps/
│       │               │   └── BaseSteps.java
│       │               └── (Diğer Java test sınıflarınız)
│       └── resources/
│           └── env/
│               └── default/
│                   └── config.properties
├── specs/
│   └── (Gauge spesifikasyon dosyalarınız)
```

### Açıklamalar:

- `pom.xml`: Maven yapılandırma dosyası.
- `manifest.json`: Gauge projesinin yapılandırma dosyası.
- `src/test/java/`: Test kodlarınızın bulunduğu dizin.
- `src/test/resources/`: Test kaynak dosyaları ve yapılandırmaları.
- `specs/`: Gauge spesifikasyonlarınızı içeren dizin.

## Maven Bağımlılıkları

`pom.xml` dosyasında kullanılan başlıca bağımlılıklar şunlardır:

- **Selenium**: Web tarayıcı otomasyonu için (version: 4.24.0)
- **WebDriverManager**: WebDriver yönetimi için (version: 5.9.2)
- **TestNG**: Test koşum çerçevesi (version: 7.10.2)
- **Gauge Java**: Gauge entegrasyonu (version: 0.11.1)
- **AssertJ**: Daha okunabilir assertion’lar için (version: 3.26.3)
- **Reflections**: Dinamik sınıf tarama için (version: 0.10.2)
- **JavaFaker**: Test verisi oluşturmak için (version: 1.0.2)
- **Rest-Assured**: API testi için (version: 5.4.0)
- **SLF4J ve Logback**: Loglama işlemleri için (versions: 2.0.7 ve 1.4.11)


## Geliştirici

- **Karya Boyraz**  - Proje Geliştiricisi
- - [GitHub Profilim](https://github.com/karyaboyraz)
- - [LinkedIn Profilim](https://www.linkedin.com/in/karya-boyraz/)


**Önemli**: Projenin sorunsuz bir şekilde çalışması için tüm gereksinimlerin ve bağımlılıkların doğru bir şekilde yüklendiğinden emin olun. Herhangi bir sorunla karşılaşırsanız veya yardım ihtiyacınız olursa, lütfen GitHub üzerinden iletişime geçin.
