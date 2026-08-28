FILESEXTRAPATHS:prepend := "${THISDIR}/openssh:"

SRC_URI += " \
    file://sshdgenkeys.conf \
    file://10-sshconfigup.conf \
"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}/sshdgenkeys.service.d/
    install -d ${D}${sysconfdir}/ssh/sshd_config.d/
    install -m 0644 ${WORKDIR}/sshdgenkeys.conf    ${D}${systemd_system_unitdir}/sshdgenkeys.service.d/
    install -m 0644 ${WORKDIR}/10-sshconfigup.conf ${D}${sysconfdir}/ssh/sshd_config.d/
    sed -i '\|^HostKey /var/run/ssh|d' ${D}${sysconfdir}/ssh/sshd_config_readonly
}

FILES:${PN} += "\
   ${systemd_system_unitdir}/sshdgenkeys.service.d/sshdgenkeys.conf \
   ${sysconfdir}/ssh/sshd_config.d/10-sshconfigup.conf \
"