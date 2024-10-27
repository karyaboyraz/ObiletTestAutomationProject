# Obilet Test Automation

Created by karya.boyraz on 24.10.2024

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.



.randomUserData.csv dosyası sayesinde dinamik olarak rastgele veri oluşturulabilir. Bu verileri kullanarak test senaryoları yazılabilir.
Aynı dosya içerisinde birden fazla veri seti oluşturulabilir ve bunlar paralel olarak veya sırayla koşulabilir.
Bunu düzenlemek için config.properties dosyası içerisindeki parametreler kullanılabilir.

Table: randomUserData.csv

* Check element existence "Otobüs Bileti için obilet" must be "visible"

## Create Travel Plan for Plane Ticket
-------------------
* Select "Flight" Transport Type
* Check element existence "Ucuz Uçak Bileti" must be "visible"
* Select Destination "Nereden" and Select Location <RandomOrigin>
* Select Destination "Nereye" and Select Location <RandomDestination>
* Select Direction on Destination "Gidiş Tarihi" and Select Date <RandomDepartureDate>
* Click "Gidiş-Dönüş" Radio button
* Select Direction on Destination "Dönüş Tarihi" and Select Date <RandomReturnDate>
* Click button "Uçuş Ara"
* Check element existence "Seferler yükleniyor" must be "visible"
* Select First "Outbound" Flight and Select Flight Package Row Number "1"
* Check element existence "Seçilen Gidiş Uçuşu" must be "visible"
* Select First "Return" Flight and Select Flight Package Row Number "1"
* Check element existence "Ödeme bilgileriniz yükleniyor" must be "visible"
* Check element existence "UÇUŞ BİLGİLERİ" must be "visible"
* Check element existence "ÖDEME BİLGİLERİ" must be "visible"
