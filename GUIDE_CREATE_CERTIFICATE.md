# How to create a new certificate?

This guide explains how to create a new self signed certifcate, used for SORMAS to SORMAS communication or 
for accessing the SurvNet interface.

**Important:** This is the first version of this guide. Please get in contact if anything is not clear or 
you have suggestions on how to improve the guide, the source code or the underlying architecture.
   
### Using the certificate generation script

1. Run ``bash ./generate-cert.sh``
2. For the generation of the certificate, the following data is needed: a password, a *Common Name* (CN) 
    and an *Organization* (O). These may be set in environment variables (recommended), or provided 
    manually as the script executes.
    * The password environment variable should be named ``SORMAS_S2S_CERT_PASS``.
    * the *Common Name* environment variable should be named ``SORMAS_S2S_CERT_CN``.<br/>
    **Important**: for Germany, this value should be the SurvNet Code Site. <br/>
    E.g. *2.03.1.01.*
    * the *Organization* (O) environment variable should be named ``SORMAS_S2S_CERT_ORG``.<br/>
    **Important**: for Germany, this value should be the name of the Health Department (Gesundheitsamt) 
    to which the SORMAS instance will be assigned. <br/>
    E.g. *GA Braunschweig*
3. After providing the requested data, the certificate files will be generated. <br/>
   The generated certificate has a validity of 3 years. 
   The certificate files will be available in the folder ``/domains/sormas/config/``.
4. The generated ``.p12`` file should not be shared with third parties. <br/>
   The generated ``.crt`` file needs to be verified and added to the shared truststore, so that this SORMAS instance 
   can communicate with other SORMAS instances. 
5. If the ``sormas.properties`` file is already available, the relevant properties will be 
    automatically set by the script.
    * If the ``sormas.properties`` file is not available, the properties which need to be added will be 
    displayed in the console after the script finishes executing.
    * Please note these properties and add them to ``sormas.properties`` when it becomes available.
    * Example output:
    ```
    sormas.properties file was not found. 
    Please add the following properties to sormas.properties after it is created:
    sormas2sormas.keyAlias=mycertificate
    sormas2sormas.keyPassword=changeit
    ```

Now you are done :-)

//TODO 
Update 4. 
Update 5. mention properties env var (which is setup with server-setup.sh), otherwise same
?also set this env var in server-setup.sh?
add custom attribute to cert generation with URL of instance
?how is cert distributed?
