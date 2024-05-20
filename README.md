# Schrödinger API - RESTful web service for solving multidimensional time-independent Schrödinger equation using Hermite DVR approach

>  Bojana Koteska (bojana.koteska@finki.ukim.mk), Anastas Mishev (anastas.mishev@finki.ukim.mk)<br>
*Ss. Cyril and Methodius University, Faculty of Computer Science and Engineering, 1000 Skopje, North Macedonia* <br>
Ljupco Pejov (ljupcop@pmf.ukim.mk)<br>
*Ss. Cyril and Methodius University, Faculty of Natural Science and Mathematics, 1000 Skopje, North Macedonia*<br>

> Website: https://schrodinger.chem-api.finki.ukim.mk/<br>
<a href="https://schrodinger.chem-api.finki.ukim.mk/static/SchrodingerAPI-Terms_of_use.pdf"> Schrödinger API - Terms of use </a><br>
<a href="https://schrodinger.chem-api.finki.ukim.mk/static/SchrodingerAPI-Privacy_policy.pdf">Schrödinger API - Privacy policy</a><br>
<a href="https://schrodinger.chem-api.finki.ukim.mk/static/SchrodingerAPI-Acceptable_use_policy.pdf">Schrödinger API - Acceptable use policy</a><br>

## DVR Techniques for solving the Schrödinger equation - Scientific background

Numerous phenomena taking place in the nano-world are inherently quantum in nature. Their description and, more important, quantitative treatment, therefore, requires usage of the apparatus of quantum mechanics. The basic paradigm of today’s “mainstream” quantum mechanics is the Schrödinger equation, which is considered as a “quantum analog” to the famous Newton’s second law equation in classical physics. When a stationary state of the considered system is of interest, the Schrödinger equation has the form:

$\hat H \psi = E \psi$ &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(1)


where $\hat H$ denotes the Hamiltonian of the system, $E$ is the energy, while $\Psi$ is the wavefunction. The Hamiltonian in (1) consists of the kinetic energy operator $(\hat K(q))$, which is a second-order differential operator in coordinate $(q)$ representation, and the potential energy operator $(\hat V(q))$:

$\hat H(q)= \hat K(q)+\hat V(q)$ &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(2)

In most of the chemical physics problems, one is interested in either molecular bound states or scattering phenomena. For such cases, the solutions of (1), $\Psi(q)$, form either a discrete set of square-integrable eigenfunctions (in $L^2$) which are localized, or (as in the scattering problems), which are not square-integrable, but the asymptotic forms of which are known, and therefore appropriate boundary conditions are applicable. As the analytical solution of (1) is known only for the simplest systems, it is necessary to have an efficient numerical method to solve it. What is often sought is a numerical solution of (1) within some finite range (e.g. finite coordinate range), which is subsequently matched to the asymptotic form. The statement of finite-range solutions has an important consequence, namely that the solution may be sought within a finite basis set composed of $n$ functions (e.g. of the relevant coordinates - $\varphi_i (q)$), as in the variational approach:

$\psi(q)=\sum_{i=1}^{n}{c_i} \cdot \varphi_i (q)$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(3)

Assuming an orthonormal set of basis functions, *i.e.*:

$\langle \varphi_i  | \varphi_j \rangle= \int {\varphi_i^\ast}(q) \cdot \varphi_j(q) \;dq= \delta_{ij}$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(4)

Equation (3) is a spectral representation of the wavefunction $\langle q |\psi \rangle$ in a truncated bases within the Hilbert space $L^2\{\langle q│ \varphi_i \rangle ;i=1,2,…,n\}$ , within the Dirac notation written as:

$\langle q│ \psi_i \rangle=\sum_{i=1}^{n}{c_i} \cdot \langle q│ \varphi_i \rangle$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(5)

inserting (3) in (1) leads to the conclusion that the expansion coefficients $c_i$ and the set of eigen energies can be found by solving the matrix eigenvalue problem (6):

$\textbf{Hc}=\textit{E}\textbf{c}$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(6)

In (6), $\textbf{c}$ is the column $n$-vector $[c_1, c_2,…, c_n]^T$, while $\textbf{H}$ is $n × n$ square matrix containing the matrix elements of the Hamiltonian $H_{ij}$, given by: 

$H_{ij}=\langle \varphi_i|\hat H|\varphi_j \rangle =\int  {\varphi_i^\ast}(q) \hat H \varphi_j(q) \;dq$ &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(7)

Such matrix-representation is often referred to as variational basis representation (VBR). As a consequence of the orthonormality of the basis set functions, it can be straightforwardly shown that the expansion coefficients in (3) and (5) are given by:

$c_k=\langle \varphi_k|\psi \rangle =\int {\langle \varphi_k|q \rangle \langle  q| \psi \rangle dq}$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(8)

Considering a Hamiltonian of the form:


$\hat H(q)= \hat H_0(q)+\hat {V}^\prime(q)$ &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(9)

where $\hat H_0(q)$ is the harmonic oscillator “zeroth order” Hamiltonian, while $\hat {V}^\prime(q)$ is the “complicated” potential energy part, the natural choice of the basis set for this problem is the one consisting of harmonic oscillator eigenfunctions, which are solutions to the “zeroth-order” (*i.e.* unperturbed) stationary Schrödinger equation:

$\hat H_{0}\psi_i=\epsilon_i\psi_i$
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(10)

In such case, the most complicated part of the calculation involves computation of the matrix elements of the form:

$V^\prime_{ij}=\langle \psi_i|{\hat V}^\prime|\psi_j \rangle=\int \psi_{i}^{*}(q)\hat V^\prime \psi_j (q)\;dq$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(11)


The first convenient numerical method for approximation of the integrals of the form (11) dates back to the works of Harris, Engerholm and Gwinn. It has been further on shown that any basis set that consists of orthogonal polynomials (such as the one constituted by harmonic oscillator eigenfunctions) can be approximated by the so-called Gaussian quadratures technique. Approximating, however, the matrix elements by any quadrature technique, leads to the consequence that the results need not be the upper limits of the exact (true) eigenvalues. Such representation of the potential energy operator is called finite basis representation (FBR), to distinguish from the previously mentioned variational basis representation (VBR). 

The quadrature approximation is a straightforward method to compute the potential energy matrix elements (11). We define an $n$-point quadrature such that it consists of the abscissa set of values (in a one-dimensional case) ${x_1, x_2,…, x_n}$ and the corresponding weights ${w_1, w_2,…, w_n}$. Such $n$-point quadrature leads to:

$V_{ij} \approx V_{ij}^{FBR}=\sum_{k=1}^{n}{w_k}\psi_i^\ast(x_k)V(x_k)\psi_j(x_k)$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(12)

Defining:

$A_{ki}\equiv w_k^{1/2}\psi_i(x_k)$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(13)

along with the diagonal matrix:

$V_{kl}^{diag}=\delta_{kl}V(x_k)$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(14)

we can easily arrive at:

$V_{ij}^{FBR}=\sum_{k=1}^{n}A_{kl}^\ast V_{kk}^{diag}A_{kj}$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(15)

In matrix notation (15) can be written as:

$V^{FBR}=A ^† V^{diag}A$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(16)

The method of Harris, Engerholm and Gwinn for computation of potential energy matrix elements is actually equivalent to using the Gaussian quadrature approach in a basis set of orthogonal polynomials. In the FBR, the potential energy matrix is written as a unitary transformation of a diagonal matrix (eq. (16)). 

The fundamental idea of the discrete variable representation (DVR) technique is to apply such unitary transformation that enables the potential energy matrix to be diagonal, *i.e.*:

$\phi_k(x)=\sum_{i=1}^{n}{A_{ki}\psi_i(x)}$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(17)

Evaluating the DVR functions at the quadrature points, one arrives at: 

$\phi_k(x_l)=\sum_{i=1}^{n}{A_{ki}\psi_i(x_l)}=\sum_{i=1}^{n}A_{ki}A_{li}w_l^{-{\frac{1}{2}}}={\delta_{kl}w_l}^{-{\frac{1}{2}}}$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(18)

Thus, it can be easily verified that any operator which is multiplicative in coordinate representation is diagonal in this basis, provided that the quadrature approximation has been used:

$\langle \phi_i|v|\phi_j \rangle=\sum_{k=1}^{n}{w_k\phi_i(x_k)V(x_k)\phi_j(x_k)}=\sum_{k=1}^{n}{\delta_{ik}V(x_k)\delta_{jk}}=V(x_k)\delta_{ij}$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(19)

As the kinetic energy matrix is not diagonal in DVR (since the kinetic energy operator is not multiplicative in coordinate representation), in the case of one-dimensional problems, the advantage of DVR over FBR is questionable. However, in multidimensional problems, the advantage of DVR becomes immediately evident. In this context, we’ll briefly exemplify the previous statement by considering a two dimensional problem, for which we will take a $N (= n_x × n_y)$ – dimensional basis represented as a direct product of two one-dimensional DVR bases:

$\chi_{ij}(x,y)=\phi_i^{x}(x) \cdot \phi_j^{y}(y), i=1,2,…,n_x,\; j=1,2,…,n_y$.&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(20)

In the basis set (20), the potential energy matrix is diagonal:

$V_{ij,i^\prime j^\prime}=\langle \phi_i^{(x)}\phi_j^{(y)}|\hat V|\phi_{i^\prime}^{(x)}\phi_{j^\prime}^{(y)} \rangle = \delta_{ii^\prime}\delta_{jj^\prime}V(x_i,y_j)$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(21)


In case of a kinetic energy operator of the form:

$\hat T= - \frac{1}{2m_x}\frac{\partial^2}{\partial x^2}-\frac{1}{2m_y}\frac{\partial^2}{\partial y^2}=\hat T^{(x)}+\hat T^{(y)}$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(22)

the corresponding kinetic energy matrix will be sparse:

$T_{ij,i^\prime j^\prime}=T_{ii^\prime}^{(x)}\delta_{jj^\prime}+\delta_{ii^\prime}T_{jj^\prime}^{(y)}$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(23)

As a consequence of this, the overall calculation of the Hamiltonian matrix with the DVR approach will be cheaper that the diagonalization.

In case of a kinetic energy operator containing cross-terms, such as e.g.:

$\hat {T}^{(xy)}=\frac{\partial^2}{\partial x \partial y}=\hat t_x \hat t_y$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(24)

the kinetic energy matrix will not be sparse:

$T_{ij,i^\prime j^\prime}^{(xy)}= t_{ii^\prime}^{(x)}t_{jj^\prime}^{(y)}$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(25)

In this case, however, one can still use techniques that significantly reduce the computational cost. For example, factorization can be very helpful in computing the matrix-vector products. Computing, e.g.:

$y_{ij}=\sum_{i^\prime j^\prime}t_{ii^\prime}^{(x)}t_{jj^\prime}^{(y)}x_{i^\prime j^\prime}$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(26)

for all $(ij)$, instead of carrying out $N^2 ( = n_x^2 n_y^2)$ operations, one can apply one factor at a time: 

$z_{i^\prime j}=\sum_{j^\prime}t_{jj^\prime}^{(y)}x_{i^\prime j^\prime}$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(27)

with a computational cost $N n_y ( = n_x n_y^2)$ operations, and subsequently:

$y_{ij}=\sum_{i^\prime}t_{ii^\prime}^{(x)}z_{i^\prime j^\prime}$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(28)

with a computational cost $N n_x ( = n_y n_x^2)$.

If the kinetic energy operator is even much more complicated, there are often many additional possibilities for its representations. 

Hereby we apply the DVR technique to solve the 1D, 2D and 3D Schrödinger equation for several model potentials that are of practical significance. These include:

- 1D Morse potential:

$V(x)=D \cdot \{1-exp[-a\cdot(x-x_0)]\}^2-D$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(29)


- 1D harmonic oscillator potential:

$V(x)=\frac{1}{2} k\cdot (x-x_0)^2$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(30)

- 1D Sombrero potential:

$V(x)=a\cdot x^2+b\cdot x^4$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(31)

- 1D Woods-Saxon potential:

$V(r)=-\frac{V_0}{\{1+exp[\frac{(r-R)}{z}]\}} ;R=r_0 \cdot a^{1/3}$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(32)

- 2D Morse potential:

$V(x,y)=D_1\cdot \{1-exp[-a\cdot(x-x_0)]\}^2-D_1+D_2\cdot\{1-exp[-a\cdot(y-y_0 )]\}^2-D_2$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(33)

- 2D harmonic oscillator potential:

$V(x,y)=\frac{1}{2} k\cdot[(x-x_0)^2+(y-y_0)^2]$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(34)

- 3D Morse potential:

$V(x,y,z)=D_1\cdot \{1-exp[-a\cdot(x-x_0)]\}^2-D_1+D_2\cdot\{1-exp[-a\cdot(y-y_0)]\}^2-D_2+D_3\cdot{1-exp[-a\cdot(z-z_0)]}^2-D_3$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(35)


- 3D harmonic oscillator potential:

$V(x,y,z)=\frac{1}{2} k\cdot[(x-x_0)^2+(y-y_0)^2+(z-z_0)^2]$&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;(36)


References:

[1]	J. V. Lill, G. A. Parker, J. C. Light, Chem. Phys. Lett. 89, 483 (1982).

[2]	D. O. Harris, G. G. Engerholm, W. D. Gwinn, J. Chem. Phys. 43, 515 (1965).

[3]	P. E. S. Wormer, G. C. Groenenbook, A. van der Avoird, J. Chem. Phys. 115, 3604 (2001).

[4]	M. Abramowitz, I. A. Stegun, Handbook of Mathematical Functions, National Bureau of Standards, Washington, D. C., 1964.

[5]	J. Stoer, R. Bulirsch, Introduction to numerical analysis, Springer, New York, 1980.



## Service description

This RESTful web service (SchrodingerAPI) provides a method for solution of **one-dimensional**, **two-dimensional** and **three-dimensional** time-independent Schrödinger equation based on the the Gauss-Hermite Discrete Variable Representation (DVR) approach. Web service source code is based on the following __[python module](https://github.com/richford/dvr_py/)__ for solving 1D Schrödinger equation, but with several code adaptations and modifications. Methods for solving 2D and 3D Schrödinger equations are developed from scratch.

The method is illustrated through different examples available for 1D, 2D and 3D cases.

The solution of [one-dimensional](#1D) Schrödinger equation is illustrated in the case of following model potentials:

-   [Morse potential](#1DMorse);
-   [Simple Harmonic Oscillator (SHO) potential](#1DSHO);
-   [Sombrero potential (Mexican hat)](#1DSomb);
-   [Woods-Saxon potential](#1DWS).



Solutions of [two-dimensional](#2D) and [three-dimensional](#3D) Schrödinger equations are illustrated for the following two model potentials:  multidimensional Morse potential and multidimensional SHO potential.


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


### Application of the DVR method for solution of one-dimensional (1D) Schrödinger equation <a id='1D'></a>

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

import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/1dHermiteMorse')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")

Example with parameters (npts=10, D=3.0, a=0.5, x0=0.0, prec=6):

import requests
response = \
requests.get('https://schrodinger.chem-api.finki.ukim.mk/1dHermiteMorse?npts=20&D=0.176&a=1.02&x0=1.4&prec=32')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")

#### 1D SHO potential <a id='1DSHO'></a>

Returns a one-dimensional harmonic oscillator potential V(x) with wavenumber k:
    
$V(x)=\frac{1}{2} k\cdot (x-x_0)^2$

Parameters:

- **npts** - number of points (default value 5) 
- **k** - wavenumber of the SHO potential (default value 1.0)
- **x0** - displacement from origin (default value 0.0)
- **prec** - precision (default value 8)

Example with default parameters:

import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/1dHermiteSho')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")

Example with parameters (npts=10, k=1.0, x0=0.0, prec=19):

import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/1dHermiteSho?npts=20&k=1.0&x0=0.0&prec=19')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")

#### 1D Sombrero potential <a id='1DSomb'></a>

Returns a one-dimensional version of the sombrero potential and requires a < 0 and b > 0
       
$V(x)=a\cdot x^2+b\cdot x^4$
       
Parameters:

- **npts** - number of points (default value 5)
- **a** - coefficient of the x^2 term (default value -5)
- **b** - coefficient of the x^4 term (default value 1.0)
- **prec** - precision (default value 8)

Example with default parameters:

import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/1dHermiteSombrero')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")

Example with parameters (npts=10, a=-5.0, b=1.0, prec=3):

import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/1dHermiteSombrero?npts=10&a=-5.0&b=1.0&prec=3')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")

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

import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/1dHermiteWoodSax')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")

Example with parameters (npts=10, V0=50.0, z=0.5, r0=1.2, A=16, prec=4):

import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/1dHermiteWoodSax?npts=10&V0=50.0&z=0.5&r0=1.2&A=16&prec=4')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")

### Application of the DVR method for solution of two-dimensional (2D) Schrödinger equation <a id='2D'></a>

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

import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/2dHermiteMorse')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")

Example with parameters (npts=10, D1=3.0, a1=0.5, D2=3.0, a2=0.5, x0=0, y0=0, prec=100):

import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/2dHermiteMorse?npts=10&D1=3.0&a1=0.5&D2=3&a2=0.5&x0=0.0&y0=0.0&prec=100')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")

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

import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/2dHermiteSho')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")

 Example with parameters (npts=5, k=1.0, x0=0.0, y0=0, prec=20):

import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/2dHermiteSho?npts=10&k=1.0&x0=0.0&y0=0.0&prec=20')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")

### Application of the DVR method for solution of three-dimensional (3D) Schrödinger equation <a id='3D'></a>

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


import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/3dHermiteMorse')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")

Example with parameters (npts=10, D1=3.0, a1=0.5, D2=3.0, a2=0.5, D3=3.0, a3=0.5, x0=0, y0=0, prec=10):

import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/3dHermiteMorse?npts=10&D1=3.0&a1=0.5&D2=3&a2=0.5&D3=3.0&a3=0.5&x0=0.0&y0=0.0&z0=0&prec=10')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")

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

import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/3dHermiteSho')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")

Example with parameters (npts=10, k=1.0, x0=0.0, y0=0, z0=0, prec=15):

import requests
response = requests.get('https://schrodinger.chem-api.finki.ukim.mk/3dHermiteSho?npts=10&k=1.0&x0=0.0&y0=0.0&z0=0.0&prec=15')
if response.status_code == 200:
        print(response.content.decode('utf-8')) 
else:
        print("None")
