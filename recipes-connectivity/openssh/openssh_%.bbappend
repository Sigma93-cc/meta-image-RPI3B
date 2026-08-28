FILESEXTRAPATHS:prepend := "${THISDIR}/openssh:"

SRC_URI += " \
    file://sshdgenkeys.conf \
    file://10-sshconfigup.conf \
"

do_install:append() {
    install -d ${D}${sysconfdir}/systemd/system/sshdgenkeys.service.d/
    install -d ${D}${sysconfdir}/ssh/sshd_config.d/
    install -m 0644 ${WORKDIR}/sshdgenkeys.conf ${D}${sysconfdir}/systemd/system/sshdgenkeys.service.d/
    install -m 0644 ${WORKDIR}/10-sshconfigup.conf ${D}${sysconfdir}/ssh/sshd_config.d/
}

FILES:${PN} += "\
   ${sysconfdir}/systemd/system/sshdgenkeys.service.d/sshdgenkeys.conf \
   ${sysconfdir}/ssh/sshd_config.d/10-sshconfigup.conf \
"