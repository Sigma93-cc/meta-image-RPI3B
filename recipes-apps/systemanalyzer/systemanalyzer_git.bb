SUMMARY = "systemAnalyzer recipe"
DESCRIPTION = "Recipe created by A.Sigov"
LICENSE = "MIT"

DEPENDS = "qtbase boost spdlog"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = " \  
    git://github.com/Sigma93-cc/systemAnalyzator.git;protocol=https;branch=develop \
    file://after_psplash.conf \
"
SRCREV = "b76323c37cccbedbfd18f697cc820a8fbde56eb7"

PV = "1.0.0+git${SRCPV}"

S = "${WORKDIR}/git"
OECMAKE_SOURCEPATH = "${S}"
EXTRA_OECMAKE += "-DSYSTEMD_UNIT_DIR=${systemd_system_unitdir}"

LIC_FILES_CHKSUM = "file://LICENSE;md5=fffb4f983a3c2feb6f5daad77d66ed13"

inherit cmake_qt5 systemd

SYSTEMD_SERVICE:${PN} += " \
    systemanalyzer.service \
"

do_install:append(){
    install -d ${D}${systemd_system_unitdir}/systemanalyzer.service.d
    install -m 0644 ${WORKDIR}/after_psplash.conf ${D}${systemd_system_unitdir}/systemanalyzer.service.d/after_psplash.conf
}

FILES:${PN} += "${systemd_system_unitdir}/systemanalyzer.service.d/after_psplash.conf"