# MNB közép arfolyam lekérdezés

<h3>AZ MNB biztosít egy szolgáltatást a közép arfolyamok lekérdezésére</h3>

Egy http POST request ide : http://www.mnb.hu/arfolyamok.asmx?singleWSDL<br>
curl -v http://www.mnb.hu/arfolyamok.asmx?singleWSDL -H "Content-Type: text/xml; charset=utf-8" -d @getinforequest.xml>getinforesult.xml

https://github.com/ladnyik/mnbkozep/blob/main/MNBKozep.java

A post data része:<br>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://www.mnb.hu/webservices/">
  <soapenv:Header/>
  <soapenv:Body>
    <web:GetCurrentExchangeRates/>
  </soapenv:Body>
</soapenv:Envelope>

<h1>A válasz:</h1>
<s:Envelope xmlns:s="http://schemas.xmlsoap.org/soap/envelope/">
    <s:Body>
        <GetCurrentExchangeRatesResponse xmlns="http://www.mnb.hu/webservices/"
            xmlns:i="http://www.w3.org/2001/XMLSchema-instance">
            <GetCurrentExchangeRatesResult>&lt;MNBCurrentExchangeRates&gt;&lt;Day
                date="2023-03-17"&gt;&lt;Rate unit="1" curr="AUD"&gt;248,17&lt;/Rate&gt;&lt;Rate
                unit="1" curr="BGN"&gt;201,49&lt;/Rate&gt;&lt;Rate unit="1"
                curr="BRL"&gt;70,75&lt;/Rate&gt;&lt;Rate unit="1"
                curr="CAD"&gt;270,19&lt;/Rate&gt;&lt;Rate unit="1"
                curr="CHF"&gt;399,62&lt;/Rate&gt;&lt;Rate unit="1"
                curr="CNY"&gt;53,74&lt;/Rate&gt;&lt;Rate unit="1"
                curr="CZK"&gt;16,45&lt;/Rate&gt;&lt;Rate unit="1"
                curr="DKK"&gt;52,92&lt;/Rate&gt;&lt;Rate unit="1"
                curr="EUR"&gt;394,08&lt;/Rate&gt;&lt;Rate unit="1"
                curr="GBP"&gt;449&lt;/Rate&gt;&lt;Rate unit="1"
                curr="HKD"&gt;47,15&lt;/Rate&gt;&lt;Rate unit="100"
                curr="IDR"&gt;2,41&lt;/Rate&gt;&lt;Rate unit="1"
                curr="ILS"&gt;100,94&lt;/Rate&gt;&lt;Rate unit="1"
                curr="INR"&gt;4,48&lt;/Rate&gt;&lt;Rate unit="1"
                curr="ISK"&gt;2,64&lt;/Rate&gt;&lt;Rate unit="100"
                curr="JPY"&gt;278,02&lt;/Rate&gt;&lt;Rate unit="100"
                curr="KRW"&gt;28,32&lt;/Rate&gt;&lt;Rate unit="1"
                curr="MXN"&gt;19,82&lt;/Rate&gt;&lt;Rate unit="1"
                curr="MYR"&gt;82,52&lt;/Rate&gt;&lt;Rate unit="1"
                curr="NOK"&gt;34,7&lt;/Rate&gt;&lt;Rate unit="1"
                curr="NZD"&gt;231,22&lt;/Rate&gt;&lt;Rate unit="1"
                curr="PHP"&gt;6,77&lt;/Rate&gt;&lt;Rate unit="1"
                curr="PLN"&gt;83,73&lt;/Rate&gt;&lt;Rate unit="1"
                curr="RON"&gt;80,1&lt;/Rate&gt;&lt;Rate unit="1"
                curr="RSD"&gt;3,36&lt;/Rate&gt;&lt;Rate unit="1"
                curr="RUB"&gt;4,83&lt;/Rate&gt;&lt;Rate unit="1"
                curr="SEK"&gt;35,33&lt;/Rate&gt;&lt;Rate unit="1"
                curr="SGD"&gt;275,6&lt;/Rate&gt;&lt;Rate unit="1"
                curr="THB"&gt;10,81&lt;/Rate&gt;&lt;Rate unit="1"
                curr="TRY"&gt;19,47&lt;/Rate&gt;&lt;Rate unit="1"
                curr="UAH"&gt;10,02&lt;/Rate&gt;&lt;Rate unit="1"
                curr="USD"&gt;370,13&lt;/Rate&gt;&lt;Rate unit="1"
                curr="ZAR"&gt;20,19&lt;/Rate&gt;&lt;/Day&gt;&lt;/MNBCurrentExchangeRates&gt;</GetCurrentExchangeRatesResult>
        </GetCurrentExchangeRatesResponse>
    </s:Body>
</s:Envelope>
