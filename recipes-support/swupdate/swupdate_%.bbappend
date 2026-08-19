FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += " \
    file://enablesystemd.cfg \
    file://swupdate.cfg \
    file://swupdate_key.pub \
    "

DEPENDS += "systemd"

do_install:append() {
    install -d ${D}${sysconfdir}
    install -m 0666 ${WORKDIR}/swupdate.cfg   ${D}${sysconfdir}/
    install -m 0644 ${WORKDIR}/swupdate_key.pub   ${D}${sysconfdir}/
}

FILES:${PN} += " \
    ${sysconfdir}/swupdate.cfg \
    ${sysconfdir}/swupdate_key.pub \
"
