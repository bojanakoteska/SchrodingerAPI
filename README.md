# Schrödinger API - RESTful web service for solving multidimensional time-independent Schrödinger equation using Hermite DVR approach

Developers: [Bojana Koteska](mailto:bojana.koteska@finki.ukim.mk)

Project Supervisors: [Anastas Mishev](mailto:anastas.mishev@finki.ukim.mk)

Scientific Advisors: [Ljupco Pejov](mailto:ljupcop@pmf.ukim.mk)

Contributors: Thanks to Vojdan Kjorverziroski for his contributions and his help in deploying the code.

[![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.11408339.svg)](https://doi.org/10.5281/zenodo.11408339)

## Overview 

This RESTful web service (SchrodingerAPI) provides a method for solution of **one-dimensional**, **two-dimensional** and **three-dimensional** time-independent Schrödinger equation based on the the Gauss-Hermite Discrete Variable Representation (DVR) approach. 


The solution of one-dimensional (1D) Schrödinger equation is illustrated in the case of following model potentials:

-   Morse potential;
-   Simple Harmonic Oscillator (SHO) potential;
-   Sombrero potential (Mexican hat);
-   Woods-Saxon potential.


Solutions of two-dimensional (2D) and three-dimensional (3D) Schrödinger equations are illustrated for the following two model potentials:  multidimensional Morse potential and multidimensional SHO potential.


## Software metadata

### Domain

Computational Physics

### Funder

European Commission under the Horizon 2020 - NI4OS-Europe, grant agreement no. 857645

### Progamming languages

Python 3, Java

### Date created

2024-05-22

### Keywords

REST API, RESTful web service, Schrödinger equation

## Service description


All service methods are GET methods and they can be tested by entering the parameters directly on the SchrodingerAPI home page (supported by Swagger) at https://schrodinger.chem-api.finki.ukim.mk/. Other possibilites to test the service methods include using browser URL bar, consuming the service methods in your source code or by using specific API testing tools such as [Postman](https://www.postman.com/).

For example, if user wants to test the **1dHermiteSho** method directly at https://schrodinger.chem-api.finki.ukim.mk/, the
first step is to click the **1dHermiteSho** method from the list :
<img src="https://b2drop.eudat.eu/s/WpDEad9PWeW4oaY/download" width="400"/>

Then, user should click the button **Try it out**:
<img src="https://b2drop.eudat.eu/s/t7QWCRwesJYaZB6/download" width="1000"/>


Next, user should enter the parameters (or use the default ones) and click the **Execute** button. The parameters for each method are presented in the next section. 

<img src="https://b2drop.eudat.eu/s/QJ3QRWddCWiNrQF/download" width="500"/>

The results will be shown in the **Response Body** form below. User can download or copy them.

<img src="https://b2drop.eudat.eu/s/SgrXDSLq7QPFeRA/download" width="1000"/>

Other way to use these REST API methods is to access it directly from the browser address bar.

If no parameters are provided, the default parameter values will be taken into consideration. For example, for the **1dHermiteSho** method the link should be:

https://schrodinger.chem-api.finki.ukim.mk/1dHermiteSho

If user wants to change only the default parameters **npts** and **k** and to provide his/hers, the URL should look like this:

https://schrodinger.chem-api.finki.ukim.mk/1dHermiteSho?npts=10&k=1

If user preffers to change other paramerets, they can be added with the &PARAMETER=VALUE

One of the options is also to consume the method in the user program source code. Examples in Python are provided in the section below.

## Build, Installation, and Execution Instructions

### Prerequisites
- Ensure you have Java Development Kit (JDK) 8 or later installed. You can download it from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- Ensure you have Apache Maven installed. You can download it from [here](https://maven.apache.org/download.cgi).
- Ensure you have Python 3 installed. You can download it from [here](https://www.python.org/downloads/).


### Build Instructions

To build this project, ensure you have Maven installed on your system. Clone the Repository, Navigate to the Project Directory, and Build the Project with Maven:**

```bash
git clone https://github.com/bojanakoteska/SchrodingerAPI.git && cd SchrodingerAPI && mvn clean package
```

### Installation Instructions

Once the build is successful, you can run the JAR file in the target directory:

```bash
java -jar SchrodingerAPI.jar
```

This command will start the application locally, and you can access it at `http://localhost:8080`.

### Execution Instructions

#### Running Locally

To run the Schrödinger API locally, follow these steps:

#### Python Dependencies

If you're using Python to interact with the Schrödinger API, make sure you have the `requests` library installed. You can install it using pip:

```python
pip install requests
```

### Examples of the DVR method for solution of one-dimensional (1D) Schrödinger equation <a id='1D'></a>

#### 1D Morse potential <a id='1DMorse'></a>

Returns a one-dimensional Morse potential V(x):

$V(x)=D \cdot \{1-exp[-a\cdot(x-x_0)]\}^2-D$

Parameters: 

- **npts** - number of points (default value 10) 
- **D** - dissociation depth(default value 3.0)
- **a** -  inverse "width" of the potential (default value 0.5)
- **x0** - equilibrium bond distance (default value 0.0)
- **prec** - precision (default value 6)

Example with default parameters:

```python
import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/1dHermiteMorse')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")
```

Example with parameters (npts=10, D=3.0, a=0.5, x0=0.0, prec=6):

```python
import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/1dHermiteMorse?npts=20&D=0.176&a=1.02&x0=1.4&prec=32')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")
```

#### 1D SHO potential <a id='1DSHO'></a>

Returns a one-dimensional harmonic oscillator potential V(x) with wavenumber k:
    
$V(x)=\frac{1}{2} k\cdot (x-x_0)^2$

Parameters:

- **npts** - number of points (default value 5) 
- **k** - wavenumber of the SHO potential (default value 1.0)
- **x0** - displacement from origin (default value 0.0)
- **prec** - precision (default value 8)

Example with default parameters:

```python
import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/1dHermiteSho')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")
```

Example with parameters (npts=10, k=1.0, x0=0.0, prec=19):

```python
import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/1dHermiteSho?npts=20&k=1.0&x0=0.0&prec=19')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")
```

#### 1D Sombrero potential <a id='1DSomb'></a>

Returns a one-dimensional version of the sombrero potential and requires a < 0 and b > 0
       
$V(x)=a\cdot x^2+b\cdot x^4$
       
Parameters:

- **npts** - number of points (default value 5)
- **a** - coefficient of the x^2 term (default value -5)
- **b** - coefficient of the x^4 term (default value 1.0)
- **prec** - precision (default value 8)

Example with default parameters:

```python
import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/1dHermiteSombrero')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")
```

Example with parameters (npts=10, a=-5.0, b=1.0, prec=3):

```python
import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/1dHermiteSombrero?npts=10&a=-5.0&b=1.0&prec=3')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")
```

#### 1D Woods-Saxon potential <a id='1DWS'></a>

Returns a Woods-Saxon potential


$V(r)=-\frac{V_0}{\{1+exp[\frac{(r-R)}{z}]\}} ;R=r_0 \cdot A^{1/3}$
       
Parameters:

- **npts** - number of points (default value 5)
- **V0** - potential depth (default value 50.0)
- **z** - surface thickness (default value 0.5)
- **r0** - rms nuclear radius (default value 1.2)
- **A** - mass number (default value 16)
- **prec** - precision (default value 8)


Example with default parameters:

```python
import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/1dHermiteWoodSax')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")
```

Example with parameters (npts=10, V0=50.0, z=0.5, r0=1.2, A=16, prec=4):

```python
import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/1dHermiteWoodSax?npts=10&V0=50.0&z=0.5&r0=1.2&A=16&prec=4')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")
```

### Examples of the DVR method for solution of two-dimensional (2D) Schrödinger equation <a id='2D'></a>

#### 2D Morse potential

 Returns a two-dimensional Morse potential V(x,y):
 
$V(x,y)=D_1\cdot \{1-exp[-a1\cdot(x-x_0)]\}^2-D_1+D_2\cdot\{1-exp[-a2\cdot(y-y_0 )]\}^2-D_2$

Parameters: 

- **npts** - number of points (default value 5) 
- **D1** - dissociation depth for x(default value 3.0)
- **a1** -  inverse "width" of the potential for x(default value 0.5)
- **x0** - equilibrium bond distance for x (default value 0.0)
- **D2** - dissociation depth for y(default value 3.0)
- **a2** -  inverse "width" of the potential for y(default value 0.5)
- **y0** - equilibrium bond distance for y (default value 0.0)
- **prec** - precision (default value 6)

Example with default parameters:

```python
import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/2dHermiteMorse')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")
```

Example with parameters (npts=10, D1=3.0, a1=0.5, D2=3.0, a2=0.5, x0=0, y0=0, prec=100):

```python
import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/2dHermiteMorse?npts=10&D1=3.0&a1=0.5&D2=3&a2=0.5&x0=0.0&y0=0.0&prec=100')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")
```

#### 2D SHO potential

Returns a two-dimensional harmonic oscillator potential V(x, y) with wavenumber k. 
       
$V(x,y)=\frac{1}{2} k\cdot[(x-x_0)^2+(y-y_0)^2]$

Parameters:

- **npts** - number of points (default value 5) 
- **k** - wavenumber of the SHO potential (default value 1.0)
- **x0** - x displacement from origin (default value 0.0)
- **y0** - y displacement from origin (default value 0.0)
- **prec** - precision (default value 8)

Example with default parameters:

```python
import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/2dHermiteSho')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")
```

 Example with parameters (npts=5, k=1.0, x0=0.0, y0=0, prec=20):

```python
import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/2dHermiteSho?npts=10&k=1.0&x0=0.0&y0=0.0&prec=20')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")
```

### Examples of the DVR method for solution of three-dimensional (3D) Schrödinger equation <a id='3D'></a>

#### 3D Morse potential

Returns a three-dimensional Morse potential V(x,y,z):


$V(x,y,z)=D_1\cdot \{1-exp[-a1\cdot(x-x_0)]\}^2-D_1+D_2\cdot\{1-exp[-a2\cdot(y-y_0)]\}^2-D_2+D_3\cdot{1-exp[-a3\cdot(z-z_0)]}^2-D_3$

  
Parameters: 

- **npts** - number of points (default value 5) 
- **D1** - dissociation depth for x(default value 3.0)
- **a1** -  inverse "width" of the potential for x(default value 0.5)
- **x0** - equilibrium bond distance for x (default value 0.0)
- **D2** - dissociation depth for y(default value 3.0)
- **a2** -  inverse "width" of the potential for y(default value 0.5)
- **y0** - equilibrium bond distance for y (default value 0.0)
- **D3** - dissociation depth for z(default value 3.0)
- **a3** -  inverse "width" of the potential for z(default value 0.5)
- **z0** - equilibrium bond distance for z (default value 0.0)
- **prec** - precision (default value 6)

Example with default parameters:


```python
import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/3dHermiteMorse')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")
```

Example with parameters (npts=10, D1=3.0, a1=0.5, D2=3.0, a2=0.5, D3=3.0, a3=0.5, x0=0, y0=0, prec=10):

```python
import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/3dHermiteMorse?npts=10&D1=3.0&a1=0.5&D2=3&a2=0.5&D3=3.0&a3=0.5&x0=0.0&y0=0.0&z0=0&prec=10')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")
```

#### 3D SHO potential

Returns a three-dimensional harmonic oscillator potential V(x, y, z) with wavenumber k. 
       
$V(x,y,z)=\frac{1}{2} k\cdot[(x-x_0)^2+(y-y_0)^2+(z-z_0)^2]$

Parameters:

- **npts** - number of points (default value 5) 
- **k** - wavenumber of the SHO potential (default value 1.0)
- **x0** - x displacement from origin (default value 0.0)
- **y0** - y displacement from origin (default value 0.0)
- **z0** - z displacement from origin (default value 0.0)
- **prec** - precision (default value 8)

Example with default parameters:

```python
import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/3dHermiteSho')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")
```

Example with parameters (npts=10, k=1.0, x0=0.0, y0=0, z0=0, prec=15):

```python
import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/3dHermiteSho?npts=10&k=1.0&x0=0.0&y0=0.0&z0=0.0&prec=15')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")
```

## License
This project is licensed under the MIT License; for more details, see the [LICENSE](https://github.com/bojanakoteska/SchrodingerAPI/blob/main/LICENSE) file.
