# Veteriner Uygulaması
 
Veteriner uygulaması olarak geliştirdiğim bu proje içerisinde evcil hayvanların özellikleri tür, cins, isim, yaş, açıklama ve sahiplerin özellikleri isim, soy isim, cep telefonu numarası, adres, e-posta şeklinde oluşturulmuştur. Evcil hayvan sahibi ve evcil hayvan arasında 1'e n olmak üzere bir ilişki kurulduğu için bir evcil hayvan sahibine birden fazla evcil hayvan tanımlaması gerçekleştirilebilmektedir. Ayrıca her kayıt üzerinde değişiklik, silme ve inceleme işlemleri yapılabilir.

Proje Java 8, Apache Maven, Spring Boot 2.6.9 ve Intellij IDEA kullanılarak geliştirilmiştir. Yerel sunucunuzda uygulamayı çalıştırdıktan sonra internet tarayıcınızın internet adresi alanına http://localhost:8080/ uzantısını yazarak uygulamaya erişebileceğiniz gibi https://vet-clinic-ms-firatyildiz.herokuapp.com/ adresi üzerinden herhangi bir IDE kullanmadan da uygulamayı görüntüleyebilirsiniz.

-----
## Kullanılan Teknolojiler
* Spring Data JPA
* Lombok
* H2 Database
* Unit Test
* Spring Security
* Thymeleaf
-----
## Katmanlar
Veteriner uygulaması configuration, controller, entity, repository, service şeklinde katmanlara sahiptir. (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/KatmanlarDetayl%C4%B1.png">Görüntülemek için tıklayınız.</a>). SOLID prensiplerine uygun bir proje hazırlamak amacıyla service işlemleri arayüzler (interface) üzerinden gerçekleştirilmiş, gelen istekleri belirli bir sıraya göre işleme almak ve bir hata durumda rollback uygulanmasını sağlamak amacıyla service sınıflarında @Transactional anotasyonu kullanılmıştır. 

Repository arayüzleri için JpaRepository kullanılmış ve OwnerRepository arayüzünde evcil hayvan sahibinin adına göre arama gerçekleştirebilmek için @Query anotasyonuyla findByName sorgusu oluşturulmuştur.

Test işlemleri, her iki service sınıfı için de gerçekleştirilmiştir;
- <a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/VetClinicManagementSystem/src/test/java/com/firatyildiz/VetClinicManagementSystem/service/OwnerServiceTest.java">OwnerServiceTest sınıfına gitmek için tıklayınız.</a> | <a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/OwnerServiceTestResult.png">Testlerin çalıştırılmış halini görmek için tıklayınız.</a>

- <a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/VetClinicManagementSystem/src/test/java/com/firatyildiz/VetClinicManagementSystem/service/PetServiceTest.java">PetServiceTest sınıfına gitmek için tıklayınız.</a> | <a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/PetServiceTestResult.png">Testlerin çalıştırılmış halini görmek için tıklayınız.</a>

Evcil hayvan sahibi veya evcil hayvan işlemlerini gerçekleştirebilmek için kullanıcı adı ve şifreye ihtiyaç duyulmaktadır (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/VetClinicManagementSystem/src/main/java/com/firatyildiz/VetClinicManagementSystem/configuration/SecurityConfiguration.java">SecurityConfiguration sınıfını görüntülemek için tıklayınız.</a>)
Kullanıcı adı ve şifre aşağıdaki gibi belirlenmiştir;
- Kullanıcı Adı: fırat
- Şifre: fırat
-----
## İşlemler

Uygulamanın çalıştırılabilir hale getirilmesi için herhangi bir IDE kullanılması gerekmemektedir. Bunun için Heroku platform servis sağlayıcısı kullanılmıştır. <a href="https://vet-clinic-ms-firatyildiz.herokuapp.com/">Buraya tıklayarak uygulamaya ulaşabilirsiniz.</a>

Yukarıdaki uzantıya tıklayarak ulaştığınız uygulama ana sayfasının üstünde bulunan menüde Home ve Login seçenekleri bulunmaktadır (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/Home.png">görsel için tıklayınız</a>). Daha önce bahsedildiği üzere evcil hayvan ve evcil hayvan sahibi işlemlerini gerçekleştirebilmek için burada bulunan Login seçeneğine tıklayarak sisteme giriş yapmanız gerekmektedir (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/Login.png">görsel için tıklayınız</a>). 
Giriş yapabilmek için yukarıda belirtilen kullanıcı adını ve şifreyi kullanabilirsiniz. Kullanıcı girişi yapıldıktan sonra ön panele yönlendirileceksiniz (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/Dashboard.png">görsel için tıklayınız</a>). Ayrıca bu işlemden sonra yukarıdaki menüde Owner, Pet, Search Owner, Dashboard seçeneklerinin de aktif hale geldiğini ve erişilebilir olduğunu göreceksiniz.

Pet seçeneğine tıkladığınızda Add Pet butonunu görebilirsiniz (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/PetDirectory.png">görsel için tıklayınız</a>). Bu butona tıklayarak evcil hayvan ekleme işlemini gerçekleştirebilirsiniz (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/AddPet.png">görsel için tıklayınız</a>). Evcil hayvan için ihtiyaç duyulan bilgiler girildikten sonra Create Pet butonuna tıklanması gerekmektedir (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/AddPet2.png">görsel için tıklayınız</a>). Bu butona tıkladıktan sonra evcil hayvan sayfasına yönlendirilirsiniz ve eklemiş olduğunuz evcil hayvan görüntülenebilir hale gelmektedir (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/PetDirectory2.png">görsel için tıklayınız</a>). Bu şekilde istenildiği kadar evcil hayvan eklenmesi yapılabilir (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/PetDirectory3.png">görsel için tıklayınız</a>).

Ardından Owner seçeneğine tıkladıktan sonra Add Owner butonu ile evcil hayvan sahibi eklenebilir (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/OwnerDirectory.png">görsel için tıklayınız</a>). Evcil hayvan sahibi eklenirken bir ya da daha fazla sayıda evcil hayvan seçilebilmektedir (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/AddOwner2.png">görsel için tıklayınız</a>). Gerekli bilgileri girdikten sonra Create Owner butonuna tıkladıktan sonra da aynı şekilde Owner Directory sayfasına yönlendirilirsiniz ve eklemiş olduğunu evcil hayvan sahipleri, evcil hayvanlarıyla birlikte görüntülenebilmektedir (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/OwnerDirectory3.png">görsel için tıklayınız</a>). 

Sayfanın üst tarafında bulunan menüden Search Owner seçeneğine tıkladığımız durumda evcil hayvan sahiplerini isimlerine göre arayabilmemizi sağlayan sayfaya ulaşmış oluruz. İsim girmeden arama yapıldığında veya arama yapılan isimde bir kayıt bulunmadığı durumda "Not Found" uyarısını alırsınız (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/SearchNotFound.png">görsel için tıklayınız</a>). Eğer girdiğiniz isimde bulunan birden fazla kayıt varsa bu durumda liste halinde kayıtlara ulaşabilirsiniz (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/SearchList.png">görsel için tıklayınız</a>). Fakat aranılan isimde sadece bir kayıt bulunuyorsa direkt olarak bulunan evcil hayvan sahibinin detay sayfasına yönlendirilirsiniz (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/SearchDetail.png">görsel için tıklayınız</a>). 

Evcil hayvan sahibi sayfasına geri döndüğümüzde de görebileceğimiz gibi kayıtları değiştirebilir, silebilir ve detay sayfalarına ulaşabiliriz (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/OwnerDirectory3.png">görsel için tıklayınız</a>). Bu işlemler her kayıt için ayrı ayrı gerçekleştirilebilir. Örnek için kayıtlar arasında bulunan Fırat Holmes kişisini Sherlock Holmes olarak değiştirdiğimizde aşağıdaki gibi görüntülenebilr (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/UpdateOwner.png">görsel için tıklayınız</a>). Ayrıca evcil hayvanın Karabas olan ismi de Moriarty olarak değiştirilebilmektedir (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/UpdatePet.png">görsel için tıklayınız</a>). Bu işlemlerden sonra tekrar Owner seçeneğine tıkladığımızda her iki değişikliğinde yansıdığını görebiliriz (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/UpdatePetAndDog.png">görsel için tıklayınız</a>). 

Delete butonuna tıklandığında görseldeki şekilde bir uyarı çıkacaktır (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/DeleteMessage.png">görsel için tıklayınız</a>). Bu uyarıya Tamam olarak cevap vermemiz durumunda kayıt silinir (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/Delete.png">görsel için tıklayınız</a>). Silinen evcil hayvan sahibi ile birlikte evcil hayvanın da kaydı silinecektir.

Ayrıca proje içerisinde oluşturulan ExceptionHandlerController sınıfı, proje içerisinde gerçekleştirilen hatalı işlemler ve bulunmayan sayfalara ulaşılmaya çalışılması sonucunda hata sayfasına yönlendirilmemizi sağlar (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/ErrorPage.png">görsel için tıklayınız</a>). Bu sayede projenin tutarlı ve güvenli bir şekilde çalışması sağlanmıştır.

Son olarak, işlemlerden sonra sistemden çıkmak için sayfanın üstünde bulunan menüden Logout seçeneğine tıklamanız gerekmektedir. Bu sayede sistemden çıkışınız gerçekleşir ve sisteme giriş sayfasına yönlendirilirsiniz (<a href="https://github.com/frtyildiz/VeterinaryClinicManagementSystem/blob/main/images/LogOut.png">görsel için tıklayınız</a>).










