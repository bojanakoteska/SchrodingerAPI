import dvr_3d_copy
import dvr_1d_copy
import sys
d1d = dvr_1d_copy.HermiteDVR(npts=int(sys.argv[1]))
d3d = dvr_3d_copy.DVR(dvr1d=d1d)
d3d.morse_test(D1=float(sys.argv[2]),a1=float(sys.argv[3]),D2=float(sys.argv[4]),a2=float(sys.argv[5]),D3=float(sys.argv[6]),a3=float(sys.argv[7]),num_eigs=int(sys.argv[1]),x0=float(sys.argv[8]),y0=float(sys.argv[9]),z0=float(sys.argv[10]),precision=int(sys.argv[11]))