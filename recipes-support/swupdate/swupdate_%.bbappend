FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += " \
    file://enablesystemd.cfg \
    file://swupdate.cfg \
    "

DEPENDS += "systemd"

do_install:append() {
    install -d ${D}${sysconfdir}
    install -m 0666 ${WORKDIR}/swupdate.cfg   ${D}${sysconfdir}/
}

FILES:${PN} += " \
    ${sysconfdir}/swupdate.cfg \
"
