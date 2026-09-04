FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

inherit systemd

SRC_URI += "\
    file://staticip.conf \
    file://10-logs.conf \
    file://logsmaker.service \
"

do_install:append(){
    install -d ${D}${sysconfdir}/systemd/network/80-wired.network.d/
    install -d ${D}${systemd_unitdir}/journald.conf.d/
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/staticip.conf ${D}${sysconfdir}/systemd/network/80-wired.network.d/
    install -m 0644 ${WORKDIR}/10-logs.conf ${D}${systemd_unitdir}/journald.conf.d/
    install -m 0644 ${WORKDIR}/logsmaker.service ${D}${systemd_system_unitdir}
}

FILES:${PN} += " \
    ${sysconfdir}/systemd/network/80-wired.network.d/staticip.conf \
    ${systemd_unitdir}/journald.conf.d/10-logs.conf \
"

SYSTEMD_SERVICE:${PN} += " \
    logsmaker.service \
"