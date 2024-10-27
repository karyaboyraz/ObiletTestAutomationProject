# Obilet Test Automation

Created by karya.boyraz on 24.10.2024

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

.randomUserData.csv dosyası sayesinde dinamik olarak rastgele veri oluşturulabilir. Bu verileri kullanarak test senaryoları yazılabilir.
Aynı dosya içerisinde birden fazla veri seti oluşturulabilir ve bunlar paralel olarak veya sırayla koşulabilir.
Bunu düzenlemek için config.properties dosyası içerisindeki parametreler kullanılabilir.

Table: randomUserData.csv

* Check element existence "Otobüs Bileti için obilet" must be "visible"

## Create Account on Obilet.com
-------------------
* Click button "Üye Girişi"
* Click button "Üye Ol"
* Write <RandomEmail> to Element "E-posta"
* Write <RandomPassword> to Element "Şifre"
* Click button "Üye Ol"
* Check element existence "Hesabım" must be "visible"


 Check element existence "Üye Ol" must be "hidden"

 Son step daha kısa sürede bitmesi için atlanmıştır güvenilirlik için tekrar eklenebilir bu şekilde