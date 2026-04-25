SUMMARY = "systemAnalyzer recipe"
DESCRIPTION = "Recipe created by A.Sigov"
LICENSE = "MIT"

DEPENDS = "qtbase boost"

SRC_URI = "git://github.com/Sigma93-cc/systemAnalyzator.git;protocol=https;branch=develop"
SRCREV = "23977296b2d500e0fed4ddc93bb17285be65ce34"

PV = "1.0.0+git${SRCPV}"

S = "${WORKDIR}/git"
OECMAKE_SOURCEPATH = "${S}/src"
prefix="/opt/systemanalyzer"

LIC_FILES_CHKSUM = "file://LICENSE;md5=fffb4f983a3c2feb6f5daad77d66ed13"

inherit cmake_qt5
